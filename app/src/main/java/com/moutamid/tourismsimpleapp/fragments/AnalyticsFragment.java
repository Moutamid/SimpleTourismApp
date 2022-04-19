package com.moutamid.tourismsimpleapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.moutamid.tourismsimpleapp.databinding.FragmentAboutBinding;
import com.moutamid.tourismsimpleapp.databinding.FragmentAnalyticsBinding;

public class AnalyticsFragment extends Fragment {

    private FragmentAnalyticsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAnalyticsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }
}