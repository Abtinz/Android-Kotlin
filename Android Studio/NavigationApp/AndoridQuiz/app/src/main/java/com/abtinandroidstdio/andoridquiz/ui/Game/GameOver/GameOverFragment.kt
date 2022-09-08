package com.abtinandroidstdio.andoridquiz.ui.Game.GameOver

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
        val args = GameOverFragmentArgs.fromBundle(requireArguments())
        Toast.makeText(context, "Your Answer: ${args.choosedOption}",Toast.LENGTH_SHORT).show()
        return binding.root

    }

}