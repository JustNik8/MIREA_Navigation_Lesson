package com.justnik.mirea_navigation_lesson.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.justnik.mirea_navigation_lesson.R
import com.justnik.mirea_navigation_lesson.databinding.FragmentCatBinding

class CatFragment : Fragment(R.layout.fragment_cat) {
    private val binding: FragmentCatBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setClickListener()
    }

    private fun setClickListener(){
        binding.bCat.setOnClickListener {
            findNavController().popBackStack(R.id.homeFragment, false)
        }
    }
}

