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

        val questionsList = Constants.getQuestions()

        val currentQuestionId = 0
        val currentQuestion = questionsList[currentQuestionId]
        questionBinding.questionText.text = currentQuestion.questionText
        questionBinding.firstOption.text = currentQuestion.firstOptionText
        questionBinding.secondOption.text = currentQuestion.secondOptionText
        questionBinding.thirdOption.text = currentQuestion.thirdOptionText
        questionBinding.fourthOption.text = currentQuestion.fourthOptionText
        questionBinding.questionImage.setImageResource(currentQuestion.Image)
        questionBinding.prograssTextView.text = "[$currentQuestionId / ${questionBinding.progressBar.max}]"


    }


}