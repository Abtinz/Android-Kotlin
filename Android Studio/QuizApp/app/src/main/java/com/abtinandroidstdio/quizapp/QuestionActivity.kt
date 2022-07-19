package com.abtinandroidstdio.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.abtinandroidstdio.quizapp.databinding.ActivityQuestionBinding
import com.abtinandroidstdio.quizapp.databinding.ActivityMainBinding
class QuestionActivity : AppCompatActivity() {
    lateinit var questionBinding : ActivityQuestionBinding
    lateinit var mainBinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        questionBinding = ActivityQuestionBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        questionBinding.UsernameText.text = "UserName: " + mainBinding.UserNameTextView.text

        setContentView(questionBinding.root)

    }


}