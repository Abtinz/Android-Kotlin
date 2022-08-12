package com.abtinandroidstdio.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.abtinandroidstdio.todolist.databinding.ActivityInputBinding
class InputActivity : AppCompatActivity() {
    lateinit var binding : ActivityInputBinding
    var inputType = "UserId"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        inputType = intent.getStringExtra("inputType").toString()
        binding.searchTtleTextView.append(inputType)
        setContentView(binding.root)

    }


    fun searchUserId(userIdList:ArrayList<Int>,taskIdList:ArrayList<Int>,taskTextList:ArrayList<String>,taskStateList:ArrayList<Boolean>,userId:Int){
        var isCorrect = false

        var userTaskIdList = ArrayList<Int>()
        var userTaskTextList = ArrayList<String>()
        var userTaskStateList = ArrayList<Boolean>()

        var index = 0
        while(index<userIdList.size){

            if(userIdList[index] == userId){
                isCorrect = true
                userTaskIdList.add(taskIdList[index])
                userTaskTextList.add(taskTextList[index])
                userTaskStateList.add(taskStateList[index])
            }


            index -=-1
        }
        if(isCorrect){
            val intentOfInputActivity = Intent(this , ToDoListActivity::class.java)

            intentOfInputActivity.putExtra("inputType","userId")
            intentOfInputActivity.putExtra("userId",userId)
            intentOfInputActivity.putExtra("taskIdList",userTaskIdList)
            intentOfInputActivity.putExtra("taskTextList",userTaskTextList)
            intentOfInputActivity.putExtra("taskStateList",userTaskStateList)
            startActivity(intentOfInputActivity)
        }else{
            Toast.makeText(this,"User Id Is Invalid!",Toast.LENGTH_SHORT).show()
        }
    }

    fun searchId(userIdList:ArrayList<Int>,taskIdList:ArrayList<Int>,taskTextList:ArrayList<String>,taskStateList:ArrayList<Boolean>){

        var isCorrect = false
        if(isCorrect){

        }else{
            Toast.makeText(this,"Is Invalid",Toast.LENGTH_SHORT).show()
        }
    }

    fun searchTaskTitle(userIdList:ArrayList<Int>,taskIdList:ArrayList<Int>,taskTextList:ArrayList<String>,taskStateList:ArrayList<Boolean>){

        var isCorrect = false
        if(isCorrect){

        }else{
            Toast.makeText(this,"Is Invalid",Toast.LENGTH_SHORT).show()
        }
    }
}