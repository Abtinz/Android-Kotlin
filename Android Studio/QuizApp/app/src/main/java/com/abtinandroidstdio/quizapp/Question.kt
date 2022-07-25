package com.abtinandroidstdio.quizapp

data class Question(
    val id : Int,
    val firstQuestionText : String,
    val secondQuestionText : String,
    val thirdQuestionText : String,
    val fourthQuestionText : String,
    val correctAnswerId : Int,
    val questionText : String
)

