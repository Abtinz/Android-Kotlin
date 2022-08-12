package com.abtinandroidstdio.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.abtinandroidstdio.todolist.databinding.ActivityMainBinding
import okhttp3.*
import org.json.JSONArray
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

            }
            override fun onResponse(call: Call, response: Response) {
                val rawJSONContext = response.body!!.string()
                Log.d("tagJson" , "Json: ${rawJSONContext}")
                val jsonArray = JSONArray(rawJSONContext)

                runOnUiThread {

                    JsonToDoList(jsonArray)

                }

            }

        })
    }

    private fun JsonToDoList(jsonArray:JSONArray){



        var userIdList = ArrayList<Int>()
        var taskIdList = ArrayList<Int>()
        var taskTextList = ArrayList<String>()
        var taskStateList = ArrayList<Boolean>()

          var index = 0
          while(index<jsonArray.length()){

               val tempJSONObject = jsonArray.getJSONObject(index)

               userIdList.add(tempJSONObject.getInt("userId"))
               taskIdList.add(tempJSONObject.getInt("id"))
               taskTextList.add(tempJSONObject.getString("title"))
               taskStateList.add(tempJSONObject.getBoolean("completed"))
               index -=-1
           }


            intentFunc(userIdList,taskIdList,taskTextList,taskStateList)


    }
     private fun intentFunc(userIdList:ArrayList<Int>,taskIdList:ArrayList<Int>,taskTextList:ArrayList<String>,taskStateList:ArrayList<Boolean>)
    {
        val intent = Intent(this , MenuActivity::class.java)

        intent.putExtra("userIdList",userIdList)
        intent.putExtra("taskIdList",taskIdList)
        intent.putExtra("taskTextList",taskTextList)
        intent.putExtra("taskStateList",taskStateList)
        startActivity(intent)
    }

}