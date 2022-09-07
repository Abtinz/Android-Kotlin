package com.abtinandroidstdio.andoridquiz.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.abtinandroidstdio.andoridquiz.R
import com.abtinandroidstdio.andoridquiz.databinding.FragmentHomeBinding
class HomeFragment : Fragment() {

    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.button.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_nav_home_to_nav_gallery)
        }
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}