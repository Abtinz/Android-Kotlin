package com.android.weather.network.quality

import android.content.Context
import android.net.ConnectivityManager

class UserNetworkChecker(private val context: Context) {
    //here we check users network status
    val checkNetwork :Boolean
    get() {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInformation = connectivityManager.activeNetworkInfo
        return networkInformation != null && networkInformation.isConnected
    }
}