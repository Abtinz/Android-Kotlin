package com.abtinandroidstdio.mynotes.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.abtinandroidstdio.mynotes.R
import com.abtinandroidstdio.mynotes.databinding.FragmentMyNotesBinding
import com.abtinandroidstdio.mynotes.db.NoteDataBase
import com.abtinandroidstdio.mynotes.ui.model.NotesAdapter
import kotlinx.coroutines.launch


class MyNotesFragment : BaseFragmentCoroutineClass() {

    lateinit var  binding : FragmentMyNotesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyNotesBinding.inflate(inflater)

        binding.newTaskButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_myNotesFragment_to_newNoteFragment)
        }

        binding.noteRecyclerView.setHasFixedSize(true)
        binding.noteRecyclerView.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
        launch {
            context?.let {
                val notesList = NoteDataBase(it).getNoteDB().getAllNotes()
                binding.noteRecyclerView.adapter = NotesAdapter(notesList)
            }
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }


}