package com.abtinandroidstdio.quizapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abtinandroidstdio.quizapp.databinding.ActivityResultBinding
import android.media.MediaPlayer
class ResultActivity : AppCompatActivity() {
    lateinit var binding : ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val username = intent.getStringExtra("username")
        val correctAnswersCount = intent.getIntExtra("correctAnswersCount" , 0)
        val wrongAnswersCount = intent.getIntExtra("wrongAnswersCount" , 0)
        val questionNumbers = intent.getIntExtra("questionNumbers" , 0)
        showResult(username , correctAnswersCount, wrongAnswersCount , questionNumbers)
    }

    fun showResult(username:String? , correctAnswersCount:Int , wrongAnswersCount:Int , questionNumbers : Int){
        var result = ((correctAnswersCount * 3 - wrongAnswersCount) *100 / (questionNumbers*3)).toDouble()
        binding.username.text = username
        binding.CorrectAnswearsTextView.append(correctAnswersCount.toString())
        binding.WrongAnswearsTextView.append(wrongAnswersCount.toString())
        binding.percentView.append(((wrongAnswersCount*100)/correctAnswersCount).toDouble().toString())
        //uername color
        if(wrongAnswersCount > correctAnswersCount){
            binding.username.setTextColor(Color.parseColor("#9A0202"))
        }
        else{
            binding.username.setTextColor(Color.parseColor("#60AF04"))
        }

        binding.resultTextView.text = "  % $result "

        if (questionNumbers == correctAnswersCount){
            victoryMusic()
            binding.imageView.setImageResource(R.drawable.ic_trophy)
        }
        else{
            binding.imageView.setImageResource(R.drawable.image1)
        }


    }

    fun victoryMusic(){
        var mediaPlayer :  MediaPlayer?=null
        mediaPlayer = MediaPlayer.create(this,R.raw.victory)
        mediaPlayer!!.start()
    }
}