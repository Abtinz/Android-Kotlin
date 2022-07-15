package com.abtinandroidstdio.quizapp

import java.io.File
import java.util.ArrayList


class Authentication_log_in constructor(Usearname:String ,Password:String){
    var isUsernameEmpty = true
    var isPasswordEmpty = true
    lateinit var logUsearname : String
    lateinit var logPassword : String

    init{
        isUsernameEmpty = Usearname.isEmpty()
        isPasswordEmpty = Password.isEmpty()
        logUsearname = Usearname
        logPassword = Password
    }

    fun isEmpty():Boolean{
        return ((!isUsernameEmpty) and (!isPasswordEmpty))
    }

    fun Password_check():Boolean{
        val url = logUsearname + ".txt"
        val userFile = File(url)
        val userDetails = userFile.readText()
        return isEmpty()
    }

}