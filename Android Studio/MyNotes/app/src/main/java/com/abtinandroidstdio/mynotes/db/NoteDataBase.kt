package com.abtinandroidstdio.mynotes.db

import androidx.room.Database

@Database(
    entities = [Note::class] ,
    version = 1
)
abstract class NoteDataBase {
    abstract fun getNoteDB():NoteDB

    companion object{
        @Volatile private var instance : NoteDataBase? = null

    }
}