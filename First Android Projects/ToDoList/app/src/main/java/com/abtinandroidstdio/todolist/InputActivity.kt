package com.abtinandroidstdio.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.abtinandroidstdio.todolist.databinding.ActivityInputBinding

class InputActivity : AppCompatActivity() {
    lateinit var binding : ActivityInputBinding
    var inputType = "UserId"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        inputType = intent.getStringExtra("inputType").toString()
        binding.searchTtleTextView.append(inputType)
        if(inputType == "Title"){
            binding.textInputLayout.visibility = View.VISIBLE

        }else{
            binding.editTextNumber.visibility = View.VISIBLE
        }
        setContentView(binding.root)


    }

    fun searchClick(view : View){


        val userIdList = intent.getIntegerArrayListExtra("userIdList")
        val taskIdList = intent.getIntegerArrayListExtra("taskIdList")
        val taskTextList = intent.getStringArrayListExtra("taskTextList")
        val taskStateList = intent.getStringArrayListExtra("taskStateList")



            if(inputType == "Title"){
                val searchedText = binding.SearchTextInput.text.toString()
                if(searchedText.isEmpty()){
                    Toast.makeText(this,"Please fill the search blank",Toast.LENGTH_SHORT).show()
                }else{
                searchTaskTitle(userIdList,taskIdList,taskTextList,taskStateList,searchedText)
                }

            }else{
                try{
                    val inputId =  Integer.parseInt(binding.editTextNumber.text.toString())

                    if(inputType == "UserId"){

                        searchUserId(userIdList,taskIdList,taskTextList,taskStateList,inputId)
                    }else{
                        if (taskTextList != null) {
                            searchId(userIdList,taskIdList,taskTextList,taskStateList,inputId)
                        }
                    }

                }catch(exception :Exception){
                    Toast.makeText(this,"Please fill the search blank with only number for $inputType",Toast.LENGTH_SHORT).show()
                }
            }

    }

    private fun searchUserId(userIdList: java.util.ArrayList<Int>?, taskIdList: java.util.ArrayList<Int>?, taskTextList:ArrayList<String>?, taskStateList: java.util.ArrayList<String>?, userId:Int){
        var isCorrect = false

        var userTaskIdList = ArrayList<Int>()
        var userTaskTextList = ArrayList<String>()
        var userTaskStateList = ArrayList<String>()
        var index = 0
        while(index<userIdList!!.size){

            if(userIdList[index] == userId){
                isCorrect = true
                taskIdList?.get(index)?.let { userTaskIdList.add(it) }
                taskTextList?.get(index)?.let { userTaskTextList.add(it) }
                taskStateList?.get(index)?.let { userTaskStateList.add(it) }
            }
            index -=-1
        }


        if(isCorrect){

            val intentOfInputActivity = Intent(this , ToDoListActivity::class.java)
            intentOfInputActivity.putExtra("inputType","userId")
            intentOfInputActivity.putExtra("userId",userId)
            intentOfInputActivity.putExtra("taskIdList",userTaskIdList)
            intentOfInputActivity.putExtra("taskTextList",userTaskTextList)
            intentOfInputActivity.putExtra("taskStateList",userTaskStateList)
            startActivity(intentOfInputActivity)
        }else{
            Toast.makeText(this,"User Id Is Invalid!",Toast.LENGTH_SHORT).show()
        }
    }

    private fun searchId(
        userIdList: java.util.ArrayList<Int>?, taskIdList: java.util.ArrayList<Int>?, taskTextList:ArrayList<String>, taskStateList: java.util.ArrayList<String>?,
        id:Int){
        val index = id-1
        val isCorrect = (index) < taskIdList!!.size
        if(isCorrect){

            val intentOfInputActivity = Intent(this , ToDoListActivity::class.java)

            intentOfInputActivity.putExtra("inputType","TaskId")
            intentOfInputActivity.putExtra("userId", userIdList?.get(index) )
            intentOfInputActivity.putExtra("taskId",id)
            intentOfInputActivity.putExtra("taskText",taskTextList[index])
            intentOfInputActivity.putExtra("taskState", taskStateList?.get(index))
            startActivity(intentOfInputActivity)


        }else{
            Toast.makeText(this,"Task ID Is Invalid",Toast.LENGTH_SHORT).show()
        }
    }

    private fun searchTaskTitle(userIdList: java.util.ArrayList<Int>?, taskIdList: java.util.ArrayList<Int>?, taskTextList:ArrayList<String>?, taskStateList: java.util.ArrayList<String>?, title:String){

        val isCorrect = taskTextList?.contains(title)
        if(isCorrect!!){
            val index = taskTextList.indexOf(title)
            val intentOfInputActivity = Intent(this , ToDoListActivity::class.java)
            intentOfInputActivity.putExtra("inputType","Title")
            intentOfInputActivity.putExtra("userId", userIdList?.get(index))
            intentOfInputActivity.putExtra("taskId", taskIdList?.get(index))
            intentOfInputActivity.putExtra("taskText",title)
            intentOfInputActivity.putExtra("taskState", taskStateList?.get(index))

            startActivity(intentOfInputActivity)
        }else{
            Toast.makeText(this,"Task Title Is Invalid!",Toast.LENGTH_SHORT).show()
        }

    }

}