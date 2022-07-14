package com.abtinandroidstdio.quizapp


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

    fun log_in_check():Boolean{
        return isEmpty()
    }
}