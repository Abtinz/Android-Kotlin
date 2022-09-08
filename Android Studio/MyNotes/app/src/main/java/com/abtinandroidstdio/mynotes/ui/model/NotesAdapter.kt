package com.abtinandroidstdio.mynotes.ui.model

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abtinandroidstdio.mynotes.db.Note

class NotesAdapter(val notesList :List<Note>):RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    class ViewHolder(val view:View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}