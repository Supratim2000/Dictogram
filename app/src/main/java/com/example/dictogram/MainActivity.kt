package com.example.dictogram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.window.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel
import com.example.dictogram.ViewModels.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var splashViewModel: MainViewModel

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
    }
}