package com.justnik.mirea_navigation_lesson.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.justnik.mirea_navigation_lesson.R
import com.justnik.mirea_navigation_lesson.databinding.FragmentDashBoardBinding
import com.justnik.mirea_navigation_lesson.enteties.City

class DashBoardFragment : Fragment(R.layout.fragment_dash_board) {

    private val binding: FragmentDashBoardBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.bTyumen.setOnClickListener {
            val city = createCity("Тюмень(Лучший город земли)", 816_700, TYUMEN_IMAGE_URL)
            findNavController().navigate(
                DashBoardFragmentDirections.actionDashBoardFragmentToCityFragment(city)
            )

        }
        binding.bMoscow.setOnClickListener {
            val city = createCity("Москва", 12_635_466, MOSCOW_IMAGE_URL)
            findNavController().navigate(
                DashBoardFragmentDirections.actionDashBoardFragmentToCityFragment(city)
            )
        }
    }


    private fun createCity(name: String, population: Int, imageUrl: String): City {
        return City(
            name = name,
            population = population,
            imageUrl = imageUrl
        )
    }

    companion object{
        private const val TYUMEN_IMAGE_URL = "https://img4.teletype.in/files/71/cd/71cde14e-9f12-4970-9dab-f16c7048edc5.jpeg"
        private const val MOSCOW_IMAGE_URL = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/db/View_of_Moscow1.jpg/481px-View_of_Moscow1.jpg"
    }
}