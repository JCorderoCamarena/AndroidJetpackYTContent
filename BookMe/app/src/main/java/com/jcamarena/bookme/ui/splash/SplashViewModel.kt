package com.jcamarena.bookme.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {



    fun initializeUserInformationIfLoggedIn() {
        viewModelScope.launch {
            // Simulate Database/API Request to retrieve User Information
            delay(3_000)

        }
    }


}