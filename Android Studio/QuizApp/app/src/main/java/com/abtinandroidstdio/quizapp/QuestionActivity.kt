package com.abtinandroidstdio.quizapp

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.abtinandroidstdio.quizapp.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {
    lateinit var questionBinding : ActivityQuestionBinding
    lateinit var questionsList : ArrayList<Question>
    var selectedOption = 0
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
        selectedOptionTag(selectedTextView)

        //changing section
        resetOptions()
        //this is how we make text view text bold
        selectedTextView.typeface = Typeface.DEFAULT_BOLD
        selectedTextView.background = ContextCompat.getDrawable(this , R.drawable.selected_option_background)
    }

    fun selectedOptionTag(selectedTextView:TextView){
        when(selectedTextView.tag.toString()){
            "firstOption" -> {
                selectedOption = 1
            }

            "secondOption" -> {
                selectedOption = 2
            }

            "thirdOption" -> {
                selectedOption = 3
            }

            "fourthOption" -> {
                selectedOption = 4
            }
        }

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
            textViewOption.background = ContextCompat.getDrawable(this , R.drawable.option_background)
        }

    }

    fun onGuidClick(view: View){
        val currentQuestion = questionsList[currentQuestionId]
        Toast.makeText(this , "The Capital of the country : \n${currentQuestion.questionHintText}" , Toast.LENGTH_SHORT).show()
    }

    fun onClearChoiceButtonClick(view: View){
        resetOptions()
        selectedOption = 0
    }

    fun onsubmitAnswearClick(view: View){

        if(selectedOption == 0){
            val maxIndex = questionBinding.progressBar.max - 1
            if(currentQuestionId < maxIndex){
                currentQuestionId -=-1
                questionCreator()
                if(currentQuestionId == maxIndex){
                    questionBinding.questionButton.text = "SHOW RESULTS"
                }
            }

        }
        else{
            if(selectedOption == questionsList[currentQuestionId].correctAnswerId){
                changeBackGround(selectedOption , R.drawable.option_background_correct_answear)
            }
        }
    }

    fun changeBackGround(optionId : Int , backGroundId :Int){

        when(optionId){
            1 -> {
                questionBinding.firstOption.background = ContextCompat.getDrawable(this , backGroundId)
            }
        }

        when(optionId){
            2 -> {
                questionBinding.secondOption.background = ContextCompat.getDrawable(this , backGroundId)
            }
        }

        when(optionId){
            3 -> {
                questionBinding.thirdOption.background = ContextCompat.getDrawable(this , backGroundId)
            }
        }

        when(optionId){
            4 -> {
                questionBinding.fourthOption.background = ContextCompat.getDrawable(this , backGroundId)
            }
        }

    }








}