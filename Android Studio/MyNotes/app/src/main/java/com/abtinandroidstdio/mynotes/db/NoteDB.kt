package com.abtinandroidstdio.mynotes.db

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface NoteDB {

    
    @Insert
    fun addNote(note: Note)//add new note
}