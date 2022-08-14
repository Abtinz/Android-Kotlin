package com.abtinandroidstdio.todolist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
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
            "userId" ->  loadTaskByUserId()
            "TaskId" ->  loadTaskByTaskId()
            "Title" ->  loadTaskByTitle()
            "Top50" ->  loadTaskByTop50()
        }
    }

    fun loadTaskByUserId(){
        var todoList =ArrayList<Todo>()
        val userId = intent.getIntExtra("userId",1)
        val userTaskIdList = intent.getIntegerArrayListExtra("taskIdList")
        val userTaskTextList = intent.getStringArrayListExtra("taskTextList")
        val userTaskStateList = intent.getStringArrayListExtra("taskStateList")

        for (index in 0 until userTaskIdList!!.size){
            val todo = Todo(userId, userTaskIdList[index], userTaskTextList!![index],userTaskStateList!![index].toBoolean())
            todoList.add(todo)
        }


        val customAdapter = CustomAdapter(this,todoList)
        binding.gridView.adapter = customAdapter
    }

    class CustomAdapter( var context: Context, var todoList:ArrayList<Todo>):BaseAdapter(){

         var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

          override fun getCount(): Int {

             return todoList.size
        }

          override fun getItem(position: Int): Any? {
            return  null
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {

            var view = view
            if(view == null){
                view = layoutInflater.inflate(R.layout.grid_items_view,viewGroup,false)
            }

            var idTextView = view?.findViewById<TextView>(R.id.TaskIdTextView)
            var userIdTextView = view?.findViewById<TextView>(R.id.userIdTextView)
            var taskTextView = view?.findViewById<TextView>(R.id.taskTitleView)
            var checkBoxForTaskSituation = view?.findViewById<CheckBox>(R.id.taskCheckBox)


            idTextView!!.text = "Task Id :     ${todoList[position].id}"
            userIdTextView!!.text = "User Id :     ${todoList[position].userId}"
            taskTextView!!.text = todoList[position].title
            checkBoxForTaskSituation!!.isChecked = todoList[position].completed



            return view!!


        }

    }

    fun loadTaskByTitle(){
        var todoList =ArrayList<Todo>()

        val userId = intent.getIntExtra("userId",1)
        val taskId = intent.getIntExtra("taskId",1)
        val taskText = intent.getStringExtra("taskText").toString()
        val taskState =  intent.getStringExtra("taskState").toString()

        todoList.add(Todo(userId,taskId,taskText,taskState.toBoolean()))

        val customAdapter = CustomAdapter(this,todoList)
        binding.gridView.adapter = customAdapter
    }
    fun loadTaskByTaskId(){
        var todoList =ArrayList<Todo>()
        val userId = intent.getIntExtra("userId",1)
        val taskId = intent.getIntExtra("taskId",1)
        val taskText = intent.getStringExtra("taskText").toString()
        val taskState =  intent.getStringExtra("taskState").toString()
        todoList.add(Todo(userId,taskId,taskText,taskState.toBoolean()))
        val customAdapter = CustomAdapter(this,todoList)
        binding.gridView.adapter = customAdapter

    }

    fun loadTaskByTop50(){

        var todoList =ArrayList<Todo>()
        val userIdList = intent.getIntegerArrayListExtra("userIdList")
        val userTaskIdList = intent.getIntegerArrayListExtra("taskIdList")
        val userTaskTextList = intent.getStringArrayListExtra("taskTextList")
        val userTaskStateList = intent.getStringArrayListExtra("taskStateList")
        for (index in 0 until 50){

            println(index)
            println(userIdList!![index])
            val todo = Todo(userIdList!![index],userTaskIdList!![index], userTaskTextList!![index],userTaskStateList!![index].toBoolean())

            todoList.add(todo)
        }


        val customAdapter = CustomAdapter(this,todoList)
        binding.gridView.adapter = customAdapter

    }



}