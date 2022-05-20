package com.abtinAndroidStdio.convertagetominute

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)    //set page of app with r.layout

        //calender button (handle button and Calender
        var calenderButton = findViewById<Button>(R.id.chooseDateFromCalanderButton)
        //text views off birthDay date and Result
        val userBirthDayDate = findViewById<TextView>(R.id.enterdBirthDayDate)
        val ageToMinute = findViewById<TextView>(R.id.AgeToMinute)
        //in this section we are setting a listener for our button
        calenderButton.setOnClickListener {
            //calender and current time in Kt and Android Std
            val calender = Calendar.getInstance()
            val currentYear = calender.get(Calendar.YEAR)
            val currentMonth = calender.get(Calendar.MONTH)
            val currentDay = calender.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this , DatePickerDialog.OnDateSetListener{

                    //the user information
                    view, year, month, dayOfMonth ->

                   var userEnterdDate = "${dayOfMonth}--${month}--${year}"
                   //date formatter and its pattern
                   val dateFormatter = SimpleDateFormat("dd--mm--yy")
                   var userSelectedDate = dateFormatter.parse(userEnterdDate)
                   var minuteOfDate = userSelectedDate.time / 6000   //user selected time is ms format no minute!
            } ,
                    //initially information about current date
                    currentYear , currentMonth , currentDay)

            datePicker.show()
        }


    }


}