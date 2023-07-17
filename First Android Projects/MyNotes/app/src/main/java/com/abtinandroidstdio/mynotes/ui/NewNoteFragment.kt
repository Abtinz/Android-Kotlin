package com.abtinandroidstdio.mynotes.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
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

        setHasOptionsMenu(true)
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

    /*
    * are you sure AlertDialog
     */
    private fun deleteNote(){
        AlertDialog.Builder(context).apply {
            setTitle("Are you sure that you need to delete ${note?.title}?")
            setMessage("There is no way to undo this operation!")
            setPositiveButton("Delete"){_,_ ->
                launch {
                    context?.let {
                        NoteDataBase(it).getNoteDB().deleteNote(note!!)
                        Navigation.findNavController(requireView()).navigate(NewNoteFragmentDirections.actionNewNoteFragmentToMyNotesFragment())
                    }

                    }
            }
            setNegativeButton("Cancel"){ _,_ ->  }
        }.create().show()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.deleteNoteOption ->  {
                if(note == null){
                    Toast.makeText(context , "This Note have not added to your note list yet!",Toast.LENGTH_SHORT).show()
                }else{
                    deleteNote()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
    }

}