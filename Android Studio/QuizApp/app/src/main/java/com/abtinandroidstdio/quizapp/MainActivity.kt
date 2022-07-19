package com.abtinandroidstdio.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.abtinandroidstdio.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }

    fun letsPlay(view : View){

        val username = binding.UsernameTextInput.text.toString()
        if(username.isEmpty())
            Toast.makeText(this,"Please fill Username field" , Toast.LENGTH_LONG).show()
        else{
            val intent = Intent(this , QuestionActivity::class.java)
            startActivity(intent)
        }
    }


}