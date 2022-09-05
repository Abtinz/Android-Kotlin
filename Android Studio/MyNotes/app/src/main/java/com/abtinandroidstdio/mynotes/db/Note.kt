package com.abtinandroidstdio.mynotes.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey()
    val id:Int ,
    val title:String,
    val note : String)
