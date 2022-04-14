package com.justnik.mirea_navigation_lesson.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.snackbar.Snackbar
import com.justnik.mirea_navigation_lesson.R
import com.justnik.mirea_navigation_lesson.databinding.FragmentHomeDetailedBinding

class HomeDetailedFragment : Fragment(R.layout.fragment_home_detailed) {

    private val binding: FragmentHomeDetailedBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setClickListeners()
    }

    private fun setClickListeners(){
        binding.bCat.setOnClickListener {
            //Навигация через action
            findNavController().navigate(R.id.action_homeDetailedFragment_to_catFragment)
        }

        binding.bDog.setOnClickListener {
            //Навигация через destination
            findNavController().navigate(R.id.dogFragment)
        }

    }
}