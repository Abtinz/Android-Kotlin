package com.example.paging.model

import kotlinx.serialization.SerialName

data class UsersInfo(
    val id:Int,
    val email: String,
    val avatar:String,
    @SerialName("first_name") val surename:String,
    @SerialName("last_name")  val lastname:String
)
