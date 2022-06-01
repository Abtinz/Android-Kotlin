package com.abtinandroidstdio.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import com.abtinandroidstdio.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding //because of scope var
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding view for easily id access
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this)) // alt enter --> split properties
        setContentView(binding.root)
        // binding. root will help us to alter our views with bulding and its like R.layout.activity_main
    }

    /*
        in this method we are casting view to button and then we will append the text of button to textView
        this is how we add the new clicked number to calculator view
     */
    fun onclickDigit(clickedNumber : View){
        val clickedButton = clickedNumber as Button
        binding.textView.append(clickedButton.text)
    }
}