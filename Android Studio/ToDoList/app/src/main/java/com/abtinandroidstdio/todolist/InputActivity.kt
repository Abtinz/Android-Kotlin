package com.abtinandroidstdio.todolist

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


    fun searchId(userIdList:ArrayList<Int>,taskIdList:ArrayList<Int>,taskTextList:ArrayList<String>,taskStateList:ArrayList<Boolean>){
        var isCorrect = false
        if(isCorrect){

        }else{
            Toast.makeText(this,"Is Invalid",Toast.LENGTH_SHORT).show()
        }
    }

    fun searchUserId(userIdList:ArrayList<Int>,taskIdList:ArrayList<Int>,taskTextList:ArrayList<String>,taskStateList:ArrayList<Boolean>){

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