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
import com.example.dictogram.ModelClasses.ApiResponseClass
import com.example.dictogram.Retrofit.RetrofitInstance
import com.example.dictogram.ViewModels.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private lateinit var splashViewModel: MainViewModel
    private lateinit var searchWordSv: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen: androidx.core.splashscreen.SplashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initializing uninitialized variables
        initVariables()

        //Splash screen waiting by creating delay in thread
        splashScreen.apply {
            setKeepOnScreenCondition {
                splashViewModel.getIsWaiting()
            }
        }

        //SearchView Listener
        searchWordSv.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    getMeaning(query)
                }
                return true;
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //Nothing to do here
                return true;
            }
        })
    }

    //Fetching word meaning using Retrofit API
    private fun getMeaning(word: String) {
        RetrofitInstance.getApiInterfaceInstance().getWordMeaning(word).enqueue(object : Callback<List<ApiResponseClass>> {
            override fun onResponse(
                call: Call<List<ApiResponseClass>>,
                response: Response<List<ApiResponseClass>>
            ) {
                if(response.isSuccessful) {
                    Toast.makeText(this@MainActivity, response.body()?.get(0)?.getMeanings()?.get(0)?.getDefinitions()?.get(0)?.getDefinition(), Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "Something went wrong!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<ApiResponseClass>>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initVariables() {
        splashViewModel = MainViewModel()
        searchWordSv = findViewById(R.id.search_word_sv)
    }
}