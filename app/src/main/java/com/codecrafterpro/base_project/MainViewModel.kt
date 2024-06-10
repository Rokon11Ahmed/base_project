package com.codecrafterpro.base_project

import androidx.lifecycle.ViewModel


class MainViewModel:ViewModel() {

    var isUserLoggedIn: Boolean = false

    init {
        userLoggedInStatus()
    }

    private fun userLoggedInStatus(){
        isUserLoggedIn = true
    }
}