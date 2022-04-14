package com.justnik.mirea_navigation_lesson.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.justnik.mirea_navigation_lesson.R;
import com.justnik.mirea_navigation_lesson.databinding.FragmentDashBoardBinding;
import com.justnik.mirea_navigation_lesson.enteties.City;

public class DashBoardFragment extends Fragment {
    private final static String TYUMEN_IMAGE_URL = "https://img4.teletype.in/files/71/cd/71cde14e-9f12-4970-9dab-f16c7048edc5.jpeg";
    private final static String MOSCOW_IMAGE_URL = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/db/View_of_Moscow1.jpg/481px-View_of_Moscow1.jpg";

    private FragmentDashBoardBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDashBoardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setClickListeners();
    }

    private void setClickListeners() {
        binding.bTyumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                City city = createCity("Тюмень(Лучший город земли)", 816_700, TYUMEN_IMAGE_URL);
                Bundle bundle = CityFragment.createBundle(city);
                Navigation.findNavController(view).navigate(
                        R.id.action_dashBoardFragment_to_cityFragment,
                        bundle
                );

            }
        });

        binding.bMoscow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                City city = createCity("Москва", 12_635_466, MOSCOW_IMAGE_URL);
                Bundle bundle = CityFragment.createBundle(city);
                Navigation.findNavController(view).navigate(
                        R.id.action_dashBoardFragment_to_cityFragment,
                        bundle
                );

            }
        });
    }

    private City createCity(String name, int population, String imageUrl) {
        return new City(name, population, imageUrl);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }


}
