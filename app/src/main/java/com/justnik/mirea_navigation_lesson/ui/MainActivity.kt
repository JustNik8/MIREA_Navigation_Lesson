package com.justnik.mirea_navigation_lesson.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.justnik.mirea_navigation_lesson.R
import com.justnik.mirea_navigation_lesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding: ActivityMainBinding by viewBinding()

    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(
            R.id.main_container
        ) as NavHostFragment
    }

    private val navController by lazy {
        navHostFragment.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBottomNav()
    }

    private fun setupBottomNav() {
        //Связывание bottom navigation с navController
        binding.mainBottomNav.setupWithNavController(navController)

        binding.mainBottomNav.setOnItemReselectedListener {
            if (binding.mainBottomNav.selectedItemId == it.itemId) {
                when (it.itemId) {
                    R.id.home -> refresh(R.id.homeFragment)
                    R.id.dashboard -> refresh(R.id.dashBoardFragment)
                    R.id.account -> refresh(R.id.accountFragment)
                }
            }
        }
    }

    private fun refresh(@IdRes destinationId: Int) {
        findNavController(R.id.main_container)
            .popBackStack(destinationId, false)
    }
}