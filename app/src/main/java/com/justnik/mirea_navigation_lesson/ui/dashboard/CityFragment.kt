package com.justnik.mirea_navigation_lesson.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.justnik.mirea_navigation_lesson.R
import com.justnik.mirea_navigation_lesson.databinding.FragmentCityBinding
import com.justnik.mirea_navigation_lesson.enteties.City

class CityFragment : Fragment(R.layout.fragment_city) {

    private val binding: FragmentCityBinding by viewBinding()

    private val args by navArgs<CityFragmentArgs>()

    private val city: City by lazy {
        args.city
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setData()
    }

    private fun setData() {
        with(binding) {
            title.text = city.name
            population.text = String.format(
                requireContext().getString(R.string.population_template, city.population)
            )

            Glide.with(requireContext())
                .load(city.imageUrl)
                .placeholder(R.drawable.ic_cloud_download)
                .into(imageView)
        }
    }
}