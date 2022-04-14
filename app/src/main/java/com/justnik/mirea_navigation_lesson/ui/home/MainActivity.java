package com.justnik.mirea_navigation_lesson.ui.home;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;
import com.justnik.mirea_navigation_lesson.R;
import com.justnik.mirea_navigation_lesson.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setUpBottomNav();

    }

    private void setUpBottomNav(){
        //Находим NavHostFragment
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.main_container);

        // Получаем navController у NavHostFragment
        NavController navController = navHostFragment.getNavController();
        //Связываем bottom navigation с navController
        NavigationUI.setupWithNavController(binding.mainBottomNav, navController);

        // Слушатель на выбранный item
        binding.mainBottomNav.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                if (binding.mainBottomNav.getSelectedItemId() == item.getItemId()){
                    switch (item.getItemId()){
                        case R.id.home:
                            refresh(R.id.homeFragment);
                            break;
                        case R.id.dashboard:
                            refresh(R.id.dashBoardFragment);
                            break;
                        case R.id.account:
                            refresh(R.id.accountFragment);
                            break;
                    }
                }
            }
        });

    }

    private void refresh(@IdRes int destinationId) {
        Navigation.findNavController(this, R.id.main_container)
                .popBackStack(destinationId, false);
    }
}