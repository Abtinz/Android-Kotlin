package com.abtinandroidstdio.todolist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
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

        for (index in 0 until userTaskIdList!!.size){
            val todo = Todo(userId, userTaskIdList[index], userTaskTextList!![index],userTaskStateList!![index].toBoolean())
            todoList.add(todo)
        }


    }

    class CustomAdapter( var context: Context,
                         var itemModel:ArrayList<Todo>):BaseAdapter(){
          override fun getCount(): Int {
            TODO("Not yet implemented")
        }

          override fun getItem(p0: Int): Any {
            TODO("Not yet implemented")
        }

        override fun getItemId(p0: Int): Long {
            TODO("Not yet implemented")
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            TODO("Not yet implemented")
        }

    }

    fun loadTaskByTitle(){

        val userId = intent.getIntExtra("userId",1)
        val taskId = intent.getIntExtra("taskId",1)
        val taskText = intent.getStringExtra("taskText").toString()
        val taskState =  intent.getStringExtra("taskState").toString()

        val todoList = Todo(userId,taskId,taskText,taskState.toBoolean())


    }
    fun loadTaskByTaskId(){

        val userId = intent.getIntExtra("userId",1)
        val taskId = intent.getIntExtra("taskId",1)
        val taskText = intent.getStringExtra("taskText").toString()
        val taskState =  intent.getStringExtra("taskState").toString()
        val todoList = Todo(userId,taskId,taskText,taskState.toBoolean())
    }

    fun loadTaskByTop50(){

        lateinit var todoList :ArrayList<Todo>
        val userIdList = intent.getIntegerArrayListExtra("userIdList")
        val userTaskIdList = intent.getIntegerArrayListExtra("taskIdList")
        val userTaskTextList = intent.getStringArrayListExtra("taskTextList")
        val userTaskStateList = intent.getStringArrayListExtra("taskStateList")
        for (index in 0 until 50){
            val todo = Todo(userIdList!![index],userTaskIdList!![index], userTaskTextList!![index],userTaskStateList!![index].toBoolean())
            todoList.add(todo)
        }
    }



}