package com.example.dictogram

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.window.SplashScreen
import androidx.appcompat.widget.SearchView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel
import com.example.dictogram.ViewModels.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var splashViewModel: MainViewModel
    private lateinit var searchWordSv: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen: androidx.core.splashscreen.SplashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initVariables()


        splashScreen.apply {
            setKeepOnScreenCondition {
                splashViewModel.getIsWaiting()
            }
        }
    }

    private fun initVariables() {
        splashViewModel = MainViewModel()
        searchWordSv = findViewById(R.id.search_word_sv)
    }
}