package com.example.dictogram

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import android.window.SplashScreen
import androidx.appcompat.widget.SearchView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.dictogram.Adapter.PhoneticsAdapter
import com.example.dictogram.ModelClasses.ApiResponseClass
import com.example.dictogram.ModelClasses.Phonetics
import com.example.dictogram.Retrofit.RetrofitInstance
import com.example.dictogram.ViewModels.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private lateinit var phoneticsRv: RecyclerView
    private lateinit var phoneticsAdapter: PhoneticsAdapter
    private lateinit var phoneticsFetchedList: ArrayList<Phonetics>
    private lateinit var splashViewModel: MainViewModel
    private lateinit var searchWordSv: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen: androidx.core.splashscreen.SplashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initializing uninitialized variables
        initVariables()

        setupPhoneticsRecyclerView()


        //Splash screen waiting by creating delay in thread
        splashScreen.apply {
            setKeepOnScreenCondition {
                //Returns false after some time delay(Initially returns true)
                splashViewModel.getIsWaiting()
            }
        }

        //SearchView Listener
        searchWordSv.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            //Execute when word will be searched
            override fun onQueryTextSubmit(query: String?): Boolean {
                if(query != null) {
                    if (query.isNotEmpty()) {
                        getMeaning(query)
                    } else {
                        Toast.makeText(this@MainActivity, "Searched word can't be empty", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Something went wrong!", Toast.LENGTH_SHORT).show()
                }
                return true;
            }

            //No need to implement this method for this project
            override fun onQueryTextChange(newText: String?): Boolean {
                //Nothing to do here
                return true;
            }
        })
    }

    private fun setupPhoneticsRecyclerView() {
        phoneticsAdapter = PhoneticsAdapter(phoneticsFetchedList, this)
        phoneticsRv.adapter = phoneticsAdapter
        phoneticsRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    //Fetching word meaning using Retrofit API
    private fun getMeaning(word: String) {
        RetrofitInstance.getApiInterfaceInstance().getWordMeaning(word).enqueue(object : Callback<List<ApiResponseClass>> {
            //Callback after fetching JSON response from API and parsing to Model class
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<List<ApiResponseClass>>, response: Response<List<ApiResponseClass>>) {
                if(response.isSuccessful) {
                    //Toast.makeText(this@MainActivity, response.body()?.get(0)?.getMeanings()?.get(0)?.getDefinitions()?.get(0)?.getDefinition(), Toast.LENGTH_SHORT).show()
                    if(response.body() != null) {
                        val listOfPhonetic: List<Phonetics>? = response.body()?.get(0)?.getPhonetics()
                        //Toast.makeText(this@MainActivity, "Size: ${listOfPhonetic?.size}", Toast.LENGTH_SHORT).show()
                        if(listOfPhonetic != null) {
                            phoneticsFetchedList.clear()
                            for(phoneticItem in listOfPhonetic) {
                                phoneticsFetchedList.add(phoneticItem)
                            }
                            phoneticsAdapter.notifyDataSetChanged()
                        } else {
                            Toast.makeText(this@MainActivity, "Something went wrong!", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Something went wrong!", Toast.LENGTH_SHORT).show()
                }
            }

            //Callback after fetching failure
            override fun onFailure(call: Call<List<ApiResponseClass>>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initVariables() {
        phoneticsRv = findViewById(R.id.phonetics_rv)
        phoneticsFetchedList = ArrayList()
        splashViewModel = MainViewModel()
        searchWordSv = findViewById(R.id.search_word_sv)
    }
}