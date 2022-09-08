package com.abtinandroidstdio.mynotes.ui.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abtinandroidstdio.mynotes.R
import com.abtinandroidstdio.mynotes.db.Note

class NotesAdapter(private val notesList :List<Note>):RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    class NotesViewHolder(val view:View):RecyclerView.ViewHolder(view)

    /*
    here we set our views models in our recycler views
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.note_view,parent,false)
        )
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = notesList.size
}