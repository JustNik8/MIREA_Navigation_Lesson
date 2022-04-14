package com.justnik.mirea_navigation_lesson.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.justnik.mirea_navigation_lesson.R
import com.justnik.mirea_navigation_lesson.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setClickListener()
    }

    private fun setClickListener() {
        binding.bDetailedInfo.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_homeDetailedFragment)
        }
    }
}