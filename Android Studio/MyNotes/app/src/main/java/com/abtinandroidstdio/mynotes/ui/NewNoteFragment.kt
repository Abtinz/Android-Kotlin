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
import kotlinx.coroutines.launch

class NewNoteFragment : BaseFragmentCoroutineClass() {

    private var note: Note? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentNewNoteBinding.inflate(inflater)



        //check that our arg is null or not
        arguments?.let {
            note = NewNoteFragmentArgs.fromBundle(it).note
            binding.newNoteTitle.setText(note?.title)
            binding.newNoteText.setText( note?.note)
        }
        binding.saveNewNoteButton.setOnClickListener { view ->
            val newNoteTitle = binding.newNoteTitle.text.toString().trim()
            val newNoteText = binding.newNoteText.text.toString().trim()

            if(newNoteTitle.isEmpty()){
                Toast.makeText(context,"please write your new note title!",Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(context,newNoteTitle,Toast.LENGTH_SHORT).show()

                try {
                    launch {
                        val newNote = Note(newNoteTitle,newNoteText)

                            context?.let {
                                if(note == null){
                                    NoteDataBase(it).getNoteDB().addNote(newNote)
                                }else{
                                    newNote.id = note!!.id
                                    NoteDataBase(it).getNoteDB().updateNote(newNote)
                                }
                            }



                    }

                    Navigation.findNavController(view).navigate(NewNoteFragmentDirections.actionNewNoteFragmentToMyNotesFragment())
                }catch (exception : Exception){
                    exception.printStackTrace()
                }

            }
        }

        return binding.root
    }

}