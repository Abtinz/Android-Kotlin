package com.abtinandroidstdio.andoridquiz.ui.Game.GameOver

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.abtinandroidstdio.andoridquiz.R

import com.abtinandroidstdio.andoridquiz.databinding.FragmentGameOverBinding

class GameOverFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentGameOverBinding.inflate(inflater)
        binding.tryAgainButton.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_gameOverFragment_to_quizQuestionsFragment)
        }
        return binding.root

    }

}