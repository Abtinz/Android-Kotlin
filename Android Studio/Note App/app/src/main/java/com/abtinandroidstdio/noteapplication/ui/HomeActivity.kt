package com.abtinandroidstdio.noteapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.abtinandroidstdio.noteapplication.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
    fun onClickNewNoteButton(view: View){
        startActivity(Intent(this,NewNoteActivity::class.java))
    }

}