package com.abtinAndroidStdio.convertagetominute

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)    //set page of app with r.layout

        //calender button (handle button and Calender
        var calenderButton = findViewById<Button>(R.id.chooseDateFromCalanderButton)
        //in this section we are setting a listener for our button
        calenderButton.setOnClickListener {
            
        }


    }


}