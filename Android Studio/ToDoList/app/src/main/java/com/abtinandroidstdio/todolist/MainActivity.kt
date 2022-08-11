package com.abtinandroidstdio.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
                jsonDownloader()
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

    fun JsonToDoList(jsonArray:JSONArray){

        var userIdList = ArrayList<Int>()
        var taskIdList = ArrayList<Int>()
        var taskTextList = ArrayList<String>()
        var taskStateList = ArrayList<Boolean>()


       try {

           var index = 0
           while(1==1){
               val tempJSONObject = jsonArray.getJSONObject(index)
               userIdList.add(tempJSONObject.getInt("userId"))
               taskIdList.add(tempJSONObject.getInt("id"))
               taskTextList.add(tempJSONObject.getString("title"))
               taskStateList.add(tempJSONObject.getBoolean("completed"))
               index -=-1
           }
       }catch (ee : Exception ){

       }

    }
    fun intentFunc(jsonObject:JSONObject){
        val intent = Intent(this , ToDoListActivity::class.java)
        //intent.putExtra()
        //intent.putExtra()
        //intent.putExtra()
        //intent.putExtra()
        startActivity(intent)
    }

}