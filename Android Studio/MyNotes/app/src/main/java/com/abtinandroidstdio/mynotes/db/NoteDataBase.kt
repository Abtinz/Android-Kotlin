package com.abtinandroidstdio.mynotes.db

import androidx.room.Database

@Database(
    entities = [Note::class] ,
    version = 1
)
abstract class NoteDataBase {
}