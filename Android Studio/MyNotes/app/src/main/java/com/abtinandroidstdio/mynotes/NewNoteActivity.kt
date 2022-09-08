package com.abtinandroidstdio.mynotes


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abtinandroidstdio.mynotes.databinding.ActivityNewNoteBinding


class NewNoteActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNewNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    /*fun onSaveButtonClick(view:View){
        val newNoteTitle = binding.title.text.toString().trim()
        val newNoteText = binding.noteText.text.toString().trim()

        if(newNoteTitle.isEmpty()){
            Toast.makeText(this,"please write your new note title!",Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(this,newNoteTitle,Toast.LENGTH_SHORT).show()
            val newNote = Note(newNoteTitle,newNoteText)
            try {

                NoteDataBase(this@NewNoteActivity).getNoteDB().addNote(newNote)
                val intent = Intent(this , MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }catch (exep : Exception){
               exep.printStackTrace()
            }

        }

    }*/


}