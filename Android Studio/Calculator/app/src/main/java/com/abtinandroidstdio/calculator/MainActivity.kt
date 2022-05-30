package com.abtinandroidstdio.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.abtinandroidstdio.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding view for easily id access
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(R.layout.activity_main)
    }
}