package com.abtinandroidstdio.weatherapp

import android.util.Log
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class JsonDownloader (jsonUrl:String){

    var urlOfDownloadingJson:String
    init {
        urlOfDownloadingJson = jsonUrl
    }

    fun downloadFunction():String{

        lateinit var rawJSONContext:String
        var client = OkHttpClient()
        var request = Request.Builder()
            .url(urlOfDownloadingJson)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                rawJSONContext = "Fail"
            }

            override fun onResponse(call: Call, response: Response) {
                rawJSONContext = response.body!!.string()
                Log.d("tagJson" , "Json: ${rawJSONContext}")

            }

        })
        return rawJSONContext
    }
}