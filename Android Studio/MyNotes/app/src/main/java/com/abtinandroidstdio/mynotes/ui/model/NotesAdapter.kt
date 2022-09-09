package com.abtinandroidstdio.mynotes.ui.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.abtinandroidstdio.mynotes.R
import com.abtinandroidstdio.mynotes.db.Note

class NotesAdapter(private val notesList :List<Note>):RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    class NotesViewHolder(val view:View):RecyclerView.ViewHolder(view){
        var titleView : TextView = view.findViewById(R.id.note_title)
        var noteView : TextView = view.findViewById(R.id.noteText)
        var noteCardView :CardView = view.findViewById(R.id.noteCardview)
    }


    /*
    here we set our views models in our recycler views
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.note_view,parent,false)
        )
    }

    /*
     * here we set our model parameters to holed view components
     */
    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
            holder.titleView.text = notesList[position].title
            holder.noteView.text = notesList[position].note
             holder.noteCardView.setOnClickListener {
                 
             }

    }

    override fun getItemCount() = notesList.size
}