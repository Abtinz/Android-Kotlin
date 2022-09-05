package com.abtinandroidstdio.mynotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.abtinandroidstdio.mynotes.databinding.ActivityNewNoteBinding
class NewNoteActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNewNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onSaveButtonClick(view:View){
        val newNoteTitle = binding.title.toString().trim()
        val newNoteText = binding.noteText.toString().trim()

        if(newNoteTitle.isEmpty()){
            Toast.makeText(this,"please write your new note title!",Toast.LENGTH_SHORT).show()
        }
        val intent = Intent(this , MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }


}