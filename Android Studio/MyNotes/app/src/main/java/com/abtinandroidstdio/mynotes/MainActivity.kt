package com.abtinandroidstdio.mynotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.abtinandroidstdio.mynotes.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickNewNoteButton(view: View){

        startActivity(Intent(this,NewNoteActivity::class.java))
    }
}