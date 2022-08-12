package com.abtinandroidstdio.todolist

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
        val userIdList = intent.getIntArrayExtra("userIdList")
        val taskIdList = intent.getIntArrayExtra("taskIdList")
        val taskTextList = intent.getStringArrayListExtra("taskTextList")
        val taskStateList = intent.getBooleanArrayExtra("taskStateList")
        setContentView(binding.root)

    }

    fun buttonClick(view : View){
        val button = view as Button
        val nextActivity = buttonStringDetector(button.text.toString())
    }

    fun  buttonStringDetector(buttonText :String):String{
        lateinit var nextActivity:String

        return nextActivity
    }
}