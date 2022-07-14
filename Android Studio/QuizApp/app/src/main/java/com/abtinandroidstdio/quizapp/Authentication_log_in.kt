package com.abtinandroidstdio.quizapp


class Authentication_log_in constructor(Usearname:String ,Password:String){
    var logInUsername : String
    var logInPassword :String

    init{
        logInUsername = Usearname
        logInPassword = Password
    }

    fun isEmpty():Boolean{
        return ((logInUsername.isEmpty()) and (logInPassword.isEmpty()))
    }

    fun log_in_check():Boolean{
        return isEmpty()
    }
}