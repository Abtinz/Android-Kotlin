package com.abtinandroidstdio.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.abtinandroidstdio.todolist.databinding.ActivityMenuBinding
class MenuActivity : AppCompatActivity() {
    lateinit var binding : ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun buttonClick(view : View){
        val button = view as Button
         buttonStringDetector(button.text.toString())
    }

    private fun  buttonStringDetector(buttonText :String){
        when(buttonText){
            "Task By UserId" ->  inputActivityIntent("UserId")
            "Task By TaskId" ->  inputActivityIntent("TaskId")
            "Task By Title" ->  inputActivityIntent("Title")
            "Top 50 Task" ->  toDoListIntent()
            "About App" ->  aboutApp()
        }
    }

    private fun toDoListIntent(){
        val userIdList = intent.getIntegerArrayListExtra("userIdList")
        val taskIdList = intent.getIntegerArrayListExtra("taskIdList")
        val taskTextList = intent.getStringArrayListExtra("taskTextList")
        val taskStateList = intent.getStringArrayListExtra("taskStateList")
        val toDoListIntent = Intent(this , InputActivity::class.java)

        toDoListIntent.putExtra("inputType","Top50")
        toDoListIntent.putExtra("userIdList",userIdList)
        toDoListIntent.putExtra("taskIdList",taskIdList)
        toDoListIntent.putExtra("taskTextList",taskTextList)
        toDoListIntent.putExtra("taskStateList",taskStateList)
        startActivity(toDoListIntent)
    }

    private fun aboutApp(){
        val intentOfInputActivity = Intent(this , AboutActivity::class.java)

        startActivity(intentOfInputActivity)
    }

    private fun inputActivityIntent(IntentText :String){

        val userIdList = intent.getIntegerArrayListExtra("userIdList")
        val taskIdList = intent.getIntegerArrayListExtra("taskIdList")
        val taskTextList = intent.getStringArrayListExtra("taskTextList")
        val taskStateList = intent.getStringArrayListExtra("taskStateList")
        val intentOfInputActivity = Intent(this , InputActivity::class.java)

        intentOfInputActivity.putExtra("inputType",IntentText)
        intentOfInputActivity.putExtra("userIdList",userIdList)
        intentOfInputActivity.putExtra("taskIdList",taskIdList)
        intentOfInputActivity.putExtra("taskTextList",taskTextList)
        intentOfInputActivity.putExtra("taskStateList",taskStateList)
        startActivity(intentOfInputActivity)


    }
}