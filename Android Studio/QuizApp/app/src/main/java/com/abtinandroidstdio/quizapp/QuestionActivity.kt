package com.abtinandroidstdio.quizapp

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.TextureView
import android.view.View
import android.widget.TextView
import com.abtinandroidstdio.quizapp.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {
    lateinit var questionBinding : ActivityQuestionBinding
    lateinit var questionsList : ArrayList<Question>
    var currentQuestionId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        questionBinding = ActivityQuestionBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(questionBinding.root)
        questionsList = Constants.getQuestions()
        questionCreator()
    }

    fun questionCreator(){
        val currentQuestion = questionsList[currentQuestionId]
        questionBinding.questionText.text = currentQuestion.questionText
        questionBinding.firstOption.text = currentQuestion.firstOptionText
        questionBinding.secondOption.text = currentQuestion.secondOptionText
        questionBinding.thirdOption.text = currentQuestion.thirdOptionText
        questionBinding.fourthOption.text = currentQuestion.fourthOptionText
        questionBinding.questionImage.setImageResource(currentQuestion.Image)
        val realCurrentQuestionId   = currentQuestionId + 1
        questionBinding.progressBar.progress = realCurrentQuestionId
        questionBinding.prograssTextView.text = "[$realCurrentQuestionId  / ${questionBinding.progressBar.max}]"
    }

    fun oneOptionClicked(view : View){
        val selectedTextView = view as TextView
        resetOptions()
        //this is how we make text view text bold
        selectedTextView.typeface = Typeface.DEFAULT_BOLD
    }

    fun resetOptions(){

        var optionsTextViewArray = ArrayList<TextView>()
        optionsTextViewArray.add(questionBinding.firstOption)
        optionsTextViewArray.add(questionBinding.secondOption)
        optionsTextViewArray.add(questionBinding.thirdOption)
        optionsTextViewArray.add(questionBinding.fourthOption)

        //this is how we make text view text default style
        for (textViewOption in optionsTextViewArray) {
            textViewOption.typeface = Typeface.DEFAULT
        }

    }






}