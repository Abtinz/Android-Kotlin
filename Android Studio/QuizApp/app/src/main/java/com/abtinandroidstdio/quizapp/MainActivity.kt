package com.abtinandroidstdio.quizapp

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
        val authenticationLogIn = Authentication_log_in(binding.UsernameTextInput.text.toString(),binding.PasswordTextInput.text.toString() )
        if(!authenticationLogIn.isEmpty())
            Toast.makeText(this,"Please fill all the fields" , Toast.LENGTH_LONG).show()
    }
}