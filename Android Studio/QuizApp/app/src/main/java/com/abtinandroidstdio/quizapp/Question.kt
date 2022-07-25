package com.abtinandroidstdio.quizapp

data class Question(
    val id : Int,
    val questionText : String,
    val Image : Int ,
    val firstOptionText : String,
    val secondOptionText : String,
    val thirdOptionText : String,
    val fourthOptionText : String,
    val correctAnswerId : Int

)

