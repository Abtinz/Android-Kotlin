package com.abtinandroidstdio.noteapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.abtinandroidstdio.noteapplication.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intentFunc()

    }

    fun intentFunc(){
        startActivity(Intent(this,HomeActivity::class.java))

    }


}