package com.abtinandroidstdio.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
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

    fun onclickDigit(view : View){
        
    }
}