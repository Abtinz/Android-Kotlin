package com.abtinandroidstdio.mynotes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.abtinandroidstdio.mynotes.R
import com.abtinandroidstdio.mynotes.databinding.FragmentNewNoteBinding
import com.abtinandroidstdio.mynotes.db.Note
import com.abtinandroidstdio.mynotes.db.NoteDataBase

class NewNoteFragment : BaseFragmentCoroutineClass() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentNewNoteBinding.inflate(inflater)

        binding.saveNewNoteButton.setOnClickListener {
            val newNoteTitle = binding.newNoteTitle.text.toString().trim()
            val newNoteText = binding.newNoteText.text.toString().trim()

            if(newNoteTitle.isEmpty()){
                Toast.makeText(context,"please write your new note title!",Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(context,newNoteTitle,Toast.LENGTH_SHORT).show()
                val newNote = Note(newNoteTitle,newNoteText)
                try {
                    //NoteDataBase(context!!).getNoteDB().addNote(newNote)
                    Navigation.findNavController(it).navigate(R.id.action_newNoteFragment_to_myNotesFragment)
                }catch (exception : Exception){
                    exception.printStackTrace()
                }

            }
        }

        return binding.root
    }

}