package com.abtinAndroidStdio.convertagetominute

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)    //set page of app with r.layout

        //calender button (handle button and Calender
        var calenderButton = findViewById<Button>(R.id.chooseDateFromCalanderButton)
        //in this section we are setting a listener for our button
        calenderButton.setOnClickListener {
            //calender and current time in Kt and Android Std
            val calender = Calendar.getInstance()
            val currentYear = calender.get(Calendar.YEAR)
            val currentMonth = calender.get(Calendar.MONTH)
            val currentDay = calender.get(Calendar.DAY_OF_MONTH)
        }


    }


}