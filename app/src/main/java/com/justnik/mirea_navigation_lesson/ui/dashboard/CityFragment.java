package com.justnik.mirea_navigation_lesson.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.justnik.mirea_navigation_lesson.R;
import com.justnik.mirea_navigation_lesson.databinding.FragmentCityBinding;
import com.justnik.mirea_navigation_lesson.enteties.City;

public class CityFragment extends Fragment {
    private final static String CITY_KEY = "city";

    private FragmentCityBinding binding;
    private City city;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null){
            throw new RuntimeException("Pass bundle through createBundle method");
        }
        this.city = getArguments().getParcelable(CITY_KEY);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCityBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setData();
    }

    private void setData() {
        binding.title.setText(city.getName());

        String formattedPopulation = String.format(
                requireContext().getString(R.string.population_template),
                city.getPopulation()
        );
        binding.population.setText(formattedPopulation);

        Glide.with(requireContext()).
                load(city.getImageUrl())
                .placeholder(R.drawable.ic_cloud_download)
                .into(binding.imageView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    public static Bundle createBundle(City city) {

        Bundle args = new Bundle();
        args.putParcelable(CITY_KEY, city);
        return args;
    }

}
