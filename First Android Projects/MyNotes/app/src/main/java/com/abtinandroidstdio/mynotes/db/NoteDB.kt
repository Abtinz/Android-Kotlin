package com.abtinandroidstdio.mynotes.db

import androidx.room.*

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

    @Delete
    suspend fun deleteNote(note: Note)
}