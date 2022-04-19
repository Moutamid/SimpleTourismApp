package com.moutamid.tourismsimpleapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.moutamid.tourismsimpleapp.activities.LoginActivity;
import com.moutamid.tourismsimpleapp.databinding.FragmentSettingsBinding;

public class SettingsFragment extends Fragment {


    private FragmentSettingsBinding b;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        b = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = b.getRoot();

        b.login1.setOnClickListener(view -> {
            startActivity(new Intent(requireActivity(), LoginActivity.class));
        });
        b.login2.setOnClickListener(view -> {
            startActivity(new Intent(requireActivity(), LoginActivity.class));
        });

        b.notificationss.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(requireActivity(), "Success!", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}