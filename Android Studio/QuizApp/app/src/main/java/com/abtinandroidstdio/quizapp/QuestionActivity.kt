package com.abtinandroidstdio.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abtinandroidstdio.quizapp.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {
    lateinit var questionBinding : ActivityQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        questionBinding = ActivityQuestionBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(questionBinding.root)

    }


}