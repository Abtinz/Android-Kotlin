package com.abtinandroidstdio.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abtinandroidstdio.todolist.databinding.ActivityInputBinding
class InputActivity : AppCompatActivity() {
    lateinit var binding : ActivityInputBinding
    var inputType = "UserId"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        inputType = intent.getStringExtra("inputType").toString()
        binding.SearchTextInput.hint = inputType
        binding.searchTtleTextView.append(inputType)
        setContentView(binding.root)

    }
}