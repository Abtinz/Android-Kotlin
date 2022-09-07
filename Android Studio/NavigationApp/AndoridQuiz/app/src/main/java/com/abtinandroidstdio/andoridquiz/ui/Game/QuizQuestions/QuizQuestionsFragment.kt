package com.abtinandroidstdio.andoridquiz.ui.Game.QuizQuestions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.abtinandroidstdio.andoridquiz.R
import com.abtinandroidstdio.andoridquiz.databinding.FragmentQuizQusetionsBinding
class QuizQuestionsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentQuizQusetionsBinding.inflate(inflater)

        binding.submitButton.setOnClickListener{
            if(binding.roomCheckBox.isChecked){
                Navigation.findNavController(it).navigate(R.id.action_quizQuestionsFragment_to_winingGameFragment)
            }else{
                Navigation.findNavController(it).navigate(R.id.action_quizQuestionsFragment_to_gameOverFragment2)
            }
        }

        return binding.root
    }


}