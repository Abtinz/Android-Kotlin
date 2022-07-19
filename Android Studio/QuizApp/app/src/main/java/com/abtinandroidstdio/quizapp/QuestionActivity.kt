package com.abtinandroidstdio.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abtinandroidstdio.quizapp.databinding.ActivityQuestionBinding
import com.abtinandroidstdio.quizapp.databinding.ActivityMainBinding
class QuestionActivity : AppCompatActivity() {
    lateinit var Question_binding : ActivityQuestionBinding
    lateinit var main_binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
    }
}