package com.abtinandroidstdio.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.abtinandroidstdio.todolist.databinding.ActivityMainBinding
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        jsonDownloader()
    }

     fun  jsonDownloader(){
        val client = OkHttpClient()
        val url = "https://jsonplaceholder.typicode.com/todos"
        val request = Request.Builder()
            .url(url)
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                jsonDownloader()
            }
            override fun onResponse(call: Call, response: Response) {
                val rawJSONContext = response.body!!.string()
                Log.d("tagJson" , "Json: ${rawJSONContext}")
                val jsonObject = JSONObject(rawJSONContext)

                runOnUiThread {

                    intentFunc(jsonObject)

                }

            }

        })
    }

    fun JsonToDoList(jsonObject:JSONObject){

    }
    fun intentFunc(jsonObject:JSONObject){
        val intent = Intent(this , ToDoListActivity::class.java)
        //intent.putExtra("jsonObject" , jsonObject)

        startActivity(intent)
    }

}