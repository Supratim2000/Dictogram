package com.example.dictogram.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

//ViewModel class created for delay splash screen for 2500ms
class MainViewModel: ViewModel() {
    private val _isWaiting = MutableStateFlow(true)
    private var isWaiting: StateFlow<Boolean> = _isWaiting.asStateFlow()

    init {
        viewModelScope.launch {
            delay(2500)
            _isWaiting.value = false
        }
    }

    public fun getIsWaiting(): Boolean {
        return isWaiting.value
    }
}