package com.abtinandroidstdio.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var  jsonObject :JSONObject
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=tehran&appid=a5ab76fae5a9227d96ff3adf0b793c8f&lang=fa"
        val jsonDownloaderObject = JsonDownloader(apiUrl)
        val jsonStr = jsonDownloaderObject.downloadFunction()
        if(jsonStr.equals("Fail")){
            Toast
        }
        jsonObject = JSONObject()




    }
}