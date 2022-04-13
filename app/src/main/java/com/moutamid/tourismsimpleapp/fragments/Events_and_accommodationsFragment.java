package com.moutamid.tourismsimpleapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.moutamid.tourismsimpleapp.databinding.FragmentEventsAndAccommodationsBinding;

public class Events_and_accommodationsFragment extends Fragment {

    private FragmentEventsAndAccommodationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEventsAndAccommodationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }
}