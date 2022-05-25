package com.abtinAndroidStdio.convertagetominute

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)    //set page of app with r.layout

        //calender button (handle button and Calender
        val calenderButton = findViewById<Button>(R.id.chooseDateFromCalanderButton)
        val calcualteButton = findViewById<Button>(R.id.calculateButton)
        //text views off birthDay date and Result
        val userBirthDayDate = findViewById<TextView>(R.id.enterdBirthDayDate)
        val ageToMinute = findViewById<TextView>(R.id.AgeToMinute)
        val ageTypeTextView = findViewById<TextView>(R.id.AgeType)
        //number text views
        var yearNumber = findViewById<TextView>(R.id.YearNumber)
        var monthNumber = findViewById<TextView>(R.id.MonthDate)
        var dayNumber = findViewById<TextView>(R.id.dayDate)
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

                   var userEnterdDate = "${dayOfMonth}--${month+1}--${year}"
                   //date formatter and its pattern
                   val dateFormatter = SimpleDateFormat("dd--mm--yy")
                   var userSelectedDate = dateFormatter.parse(userEnterdDate)
                   var minuteOfDate = userSelectedDate.time / 6000   //user selected time is ms format no minute!
                   var systemMinute = System.currentTimeMillis()
                   var currentDate = dateFormatter.parse(dateFormatter.format(systemMinute))
                   var currentMinute = currentDate.time / 6000

                   var timeDifference = currentMinute - minuteOfDate
                   userBirthDayDate.setText(userEnterdDate)
                   ageToMinute.setText(timeDifference.toString())
                   ageTypeTextView.setText(AgeType(timeDifference))
            } ,
                    //initially information about current date
                    currentYear , currentMonth , currentDay)
            datePicker.datePicker.maxDate = Date().time
            datePicker.show()
        }

        calcualteButton.setOnClickListener {


            var userEnterdDate = "${dayNumber.text}--${monthNumber.text}--${yearNumber.text}"

            val dateFormatter = SimpleDateFormat("dd--mm--yy")
            var userSelectedDate = dateFormatter.parse(userEnterdDate)
            val minuteOfBirthDayDate = userSelectedDate.time / 60000

            var systemMinute = System.currentTimeMillis()
            var currentDay = dateFormatter.parse(dateFormatter.format(systemMinute))
            var currentMinute = currentDay.time / 60000

            var timeDifference = currentMinute - minuteOfBirthDayDate
            userBirthDayDate.setText(userEnterdDate)
            ageToMinute.setText(timeDifference.toString())
            ageToMinute.setText(timeDifference.toString())
            ageTypeTextView.setText(AgeType(timeDifference))


        }


    }

    fun AgeType(minutesOfAge: Long) : String{

        val countOfYearsOfUserLife = minutesOfAge / 525600
        if (countOfYearsOfUserLife in 0..3)
                     return "(انرژی و سرزندگی)طفولیت"
        else if (countOfYearsOfUserLife in 3..6)
                 return "بدو کودکی( بازیگوشی)"

        else if (countOfYearsOfUserLife in 6..8)
            return "اواسط کودکی(تخیل)"

        else if (countOfYearsOfUserLife in 9..12)
            return "اواخر کودکی (ابتکار و خلاقیت)"

        else if (countOfYearsOfUserLife in 12..20)
            return "نوجوانی و بلوغ (شور و اشتیاق)"

        else if (countOfYearsOfUserLife in 20..35)
            return "بدو جوانی (همت و پشتکار)"

        else if (countOfYearsOfUserLife in 35..50)
            return "میانسالی (تعمق و ژرف اندیشی)"

        else if (countOfYearsOfUserLife in 50..80)
            return "بلوغ بزرگسالی (سخاوت و خیرخواهی)"



        else
               return "خردمندی و فضیلت(خردمندی و فضیلت)"
    }
}