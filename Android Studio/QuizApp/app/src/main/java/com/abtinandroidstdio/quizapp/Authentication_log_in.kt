package com.abtinandroidstdio.quizapp


class Authentication_log_in constructor(Usearname:String ,Password:String){
    var isUsernameEmpty = true
    var isPasswordEmpty = true

    init{
        isUsernameEmpty = Usearname.isEmpty()
        isPasswordEmpty = Password.isEmpty()
    }

    fun isEmpty():Boolean{
        return ((!isUsernameEmpty) and (!isPasswordEmpty))
    }

    fun log_in_check():Boolean{
        return isEmpty()
    }
}