package com.abtinandroidstdio.weatherapp

import okhttp3.OkHttpClient
import okhttp3.Request

class JsonDownloader (jsonUrl:String){
    lateinit var urlOfDownloadingJson:String
    init {
        urlOfDownloadingJson = jsonUrl
    }
}