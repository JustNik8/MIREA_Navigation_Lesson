package com.justnik.mirea_navigation_lesson.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.justnik.mirea_navigation_lesson.R
import com.justnik.mirea_navigation_lesson.databinding.FragmentDogBinding

class DogFragment : Fragment(R.layout.fragment_dog) {
    private val binding: FragmentDogBinding by viewBinding()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setClickListener()
    }

    private fun setClickListener() {
        binding.bDog.setOnClickListener {
            findNavController().popBackStack(R.id.homeFragment, false)
        }
    }
}