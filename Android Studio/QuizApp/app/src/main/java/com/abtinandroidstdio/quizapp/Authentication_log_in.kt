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

    fun username_check():Boolean{
        val url = "$logUsearname.txt"
        try{
            val userFile = File(url)
            return userFile.createNewFile()
        }
        catch (ex : Exception){
            return false
        }

    }
    fun Password_check():Boolean{
        val url = "$logUsearname.txt"
        val userFile = File(url)
        var userDetails = ArrayList<String>()
        userFile.forEachLine {
            userDetails.add(it)
        }
        return "Password: $logPassword".equals(userDetails[0])
    }

}