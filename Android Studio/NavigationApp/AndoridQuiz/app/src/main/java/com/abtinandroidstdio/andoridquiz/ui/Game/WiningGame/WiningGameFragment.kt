package com.abtinandroidstdio.andoridquiz.ui.Game.WiningGame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.abtinandroidstdio.andoridquiz.R
import com.abtinandroidstdio.andoridquiz.databinding.FragmentWiningGameBinding

class WiningGameFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentWiningGameBinding.inflate(inflater)
        
        return binding.root
    }

}