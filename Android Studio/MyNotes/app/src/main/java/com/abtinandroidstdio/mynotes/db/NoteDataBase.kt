package com.abtinandroidstdio.mynotes.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Note::class] ,
    version = 1
)
abstract class NoteDataBase :RoomDatabase(){
    abstract fun getNoteDB():NoteDB

    companion object{

        @Volatile private var instance : NoteDataBase? = null

        private val LOCK = Any()

        private fun dbBuilder(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            NoteDataBase::class.java,
            "notesDB"
        ).build()

        operator fun invoke(context : Context) = instance ?: synchronized(LOCK){
            instance ?: dbBuilder(context).also {
                instance = it
            }
        }

    }
}