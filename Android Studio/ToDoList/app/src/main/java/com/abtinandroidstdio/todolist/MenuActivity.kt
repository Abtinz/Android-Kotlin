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

    fun  buttonStringDetector(buttonText :String){

        when(buttonText){
            "Task By UserId" ->  InputActivityIntent("UserId")
            "Task By TaskId" ->  InputActivityIntent("TaskId")
            "Task By Title" ->  InputActivityIntent("Title")
            "Top 50 Task" ->  TODO()
            "About App" ->  TODO()
        }


    }

    fun InputActivityIntent(IntentText :String){

        val userIdList = intent.getIntArrayExtra("userIdList")
        val taskIdList = intent.getIntArrayExtra("taskIdList")
        val taskTextList = intent.getStringArrayListExtra("taskTextList")
        val taskStateList = intent.getBooleanArrayExtra("taskStateList")
        val intentOfInputActivity = Intent(this , InputActivity::class.java)

        intentOfInputActivity.putExtra("inputType",IntentText)
        intentOfInputActivity.putExtra("userIdList",userIdList)
        intentOfInputActivity.putExtra("taskIdList",taskIdList)
        intentOfInputActivity.putExtra("taskTextList",taskTextList)
        intentOfInputActivity.putExtra("taskStateList",taskStateList)
        startActivity(intentOfInputActivity)


    }
}