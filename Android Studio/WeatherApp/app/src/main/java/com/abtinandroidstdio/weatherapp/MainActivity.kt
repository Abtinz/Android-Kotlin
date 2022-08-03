package com.abtinandroidstdio.weatherapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialFunc()
    }

    fun initialFunc(){
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://api.openweathermap.org/data/2.5/weather?q=tehran&appid=a5ab76fae5a9227d96ff3adf0b793c8f&lang=fa")
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }
            override fun onResponse(call: Call, response: Response) {
                val rawJSONContex = response.body!!.string()
                Log.d("tagJson" , "Json: ${rawJSONContex}")
                val jsonObject = JSONObject(rawJSONContex)

                runOnUiThread {
                    cityNameFunc(jsonObject)
                }

            }

        })
    }

    fun cityNameFunc(jsonObject:JSONObject){
        val cityName = jsonObject.getString("name")
        
    }
}