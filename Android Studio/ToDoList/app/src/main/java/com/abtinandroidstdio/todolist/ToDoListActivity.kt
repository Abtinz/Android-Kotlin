package com.abtinandroidstdio.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abtinandroidstdio.todolist.databinding.ActivityToDoListBinding
class ToDoListActivity : AppCompatActivity() {
    lateinit var binding :ActivityToDoListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityToDoListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadTask()
    }

    private fun loadTask(){
        when(intent.getStringExtra("inputType").toString()){
            "UserId" ->  loadTaskByUserId()
            "TaskId" ->  loadTaskByTaskId()
            "Title" ->  loadTaskByTitle()
            "Top50" ->  loadTaskByTop50()
        }
    }

    fun loadTaskByUserId(){

        lateinit var todoList :ArrayList<Todo>
        val userId = intent.getIntExtra("userId",1)
        val userTaskIdList = intent.getIntegerArrayListExtra("taskIdList")
        val userTaskTextList = intent.getStringArrayListExtra("taskTextList")
        val userTaskStateList = intent.getStringArrayListExtra("taskStateList")


    }

    fun loadTaskByTitle(){

    }
    fun loadTaskByTaskId(){

    }
    fun loadTaskByTop50(){

    }
}