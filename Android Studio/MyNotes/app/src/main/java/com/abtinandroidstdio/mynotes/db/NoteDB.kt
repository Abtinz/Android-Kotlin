package com.abtinandroidstdio.mynotes.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDB {

    @Insert
    suspend fun addNote(note: Note)//add new note

    @Insert
    suspend fun addMultipleNotes(vararg note: Note)

    @Query("SELECT * FROM note ORDER BY id DESC")
    suspend fun getAllNotes():List<Note>

    @Update
    suspend fun updateNote(note: Note)
}