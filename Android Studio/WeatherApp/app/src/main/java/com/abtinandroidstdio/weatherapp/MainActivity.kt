package com.abtinandroidstdio.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var client = OkHttpClient()
        var request = Request.Builder()
            .url("https://jsonplaceholder.typicode.com/todos/1")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                val rawJSONContex = response.body!!.string()
                Log.d("tagJson" , "Json: ${rawJSONContex}")
                val jsonObject = JSONObject(rawJSONContex)
                val userId = jsonObject.getInt("userId")
                val Id = jsonObject.getInt("id")

            }

        })
    }
}