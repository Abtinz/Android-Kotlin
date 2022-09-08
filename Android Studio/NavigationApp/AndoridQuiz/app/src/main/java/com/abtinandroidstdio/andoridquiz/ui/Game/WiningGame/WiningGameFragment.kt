package com.abtinandroidstdio.andoridquiz.ui.Game.WiningGame

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.abtinandroidstdio.andoridquiz.R
import com.abtinandroidstdio.andoridquiz.databinding.FragmentWiningGameBinding

class WiningGameFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentWiningGameBinding.inflate(inflater)

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main,menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,Navigation.findNavController(requireView()))
                || super.onOptionsItemSelected(item)
    }
}