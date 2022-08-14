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
        lateinit var todoList :Todo
        val userId = intent.getIntExtra("userId",1)
        val taskId = intent.getIntExtra("taskId",1)
        val taskText = intent.getStringExtra("taskText").toString()
        val taskState =  intent.getStringExtra("taskState").toString()

    }
    fun loadTaskByTaskId(){

        lateinit var todoList :Todo
        val userId = intent.getIntExtra("userId",1)
        val taskId = intent.getIntExtra("taskId",1)
        val taskText = intent.getStringExtra("taskText").toString()
        val taskState =  intent.getStringExtra("taskState").toString()
    }
    fun loadTaskByTop50(){

        lateinit var todoList :ArrayList<Todo>
        val userIdList = intent.getIntegerArrayListExtra("userIdList")
        val userTaskIdList = intent.getIntegerArrayListExtra("taskIdList")
        val userTaskTextList = intent.getStringArrayListExtra("taskTextList")
        val userTaskStateList = intent.getStringArrayListExtra("taskStateList")
    }
}