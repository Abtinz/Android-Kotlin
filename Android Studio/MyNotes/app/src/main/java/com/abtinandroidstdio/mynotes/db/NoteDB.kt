package com.abtinandroidstdio.mynotes.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDB {


    @Insert
    fun addNote(note: Note)//add new note

    @Insert
    fun addMultipleNotes(vararg note: Note)

    @Query("SELECT * FROM note")
    fun getAllNotes():List<Note>


}