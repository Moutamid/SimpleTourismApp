package com.moutamid.tourismsimpleapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.moutamid.tourismsimpleapp.databinding.FragmentFoodBinding;

public class FoodFragment extends Fragment {


    private FragmentFoodBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFoodBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }
}