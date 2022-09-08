package com.abtinandroidstdio.mynotes.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.abtinandroidstdio.mynotes.R
import com.abtinandroidstdio.mynotes.databinding.FragmentMyNotesBinding
import com.abtinandroidstdio.mynotes.db.NoteDataBase
import kotlinx.coroutines.launch


class MyNotesFragment : BaseFragmentCoroutineClass() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMyNotesBinding.inflate(inflater)

        binding.newTaskButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_myNotesFragment_to_newNoteFragment)
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        launch {
            context?.let {
                val notesList = NoteDataBase(it).getNoteDB().getAllNotes()
            }
        }
    }


}