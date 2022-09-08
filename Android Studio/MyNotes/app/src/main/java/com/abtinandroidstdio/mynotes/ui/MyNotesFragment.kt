package com.abtinandroidstdio.mynotes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.abtinandroidstdio.mynotes.R
import com.abtinandroidstdio.mynotes.databinding.FragmentMyNotesBinding


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


}