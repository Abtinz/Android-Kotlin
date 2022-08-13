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
            "About App" ->  aboutApp()
        }


    }

    fun aboutApp(){
        val intentOfInputActivity = Intent(this , AboutActivity::class.java)

        startActivity(intentOfInputActivity)
    }

    fun InputActivityIntent(IntentText :String){

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