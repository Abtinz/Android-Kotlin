package com.abtinandroidstdio.mynotes


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abtinandroidstdio.mynotes.databinding.ActivityNewNoteBinding


class NewNoteActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNewNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    /*fun onSaveButtonClick(view:View){
        val newNoteTitle = binding.title.text.toString().trim()
        val newNoteText = binding.noteText.text.toString().trim()


    }*/


}