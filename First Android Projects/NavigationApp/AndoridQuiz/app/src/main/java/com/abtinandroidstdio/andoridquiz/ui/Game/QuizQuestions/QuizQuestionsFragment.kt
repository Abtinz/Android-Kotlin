package com.abtinandroidstdio.andoridquiz.ui.Game.QuizQuestions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.abtinandroidstdio.andoridquiz.databinding.FragmentQuizQusetionsBinding

class QuizQuestionsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentQuizQusetionsBinding.inflate(inflater)
        var choosedOption = "You have not chose any option "
        binding.submitButton.setOnClickListener{
            if(binding.roomCheckBox.isChecked){
                Navigation.findNavController(it).navigate(QuizQuestionsFragmentDirections.actionQuizQuestionsFragmentToWiningGameFragment())
            }else{
                if(binding.retrofitCheckBox.isChecked){
                    choosedOption = "Retrofit is wrong answer"
                }else{
                    choosedOption = "Navigation is wrong answer"
                }
                Navigation.findNavController(it).navigate(QuizQuestionsFragmentDirections.actionQuizQuestionsFragmentToGameOverFragment2(choosedOption))
            }
        }

        return binding.root
    }


}