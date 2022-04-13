package com.moutamid.tourismsimpleapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.moutamid.tourismsimpleapp.R;
import com.moutamid.tourismsimpleapp.brain.Brain;
import com.moutamid.tourismsimpleapp.databinding.FragmentDestinationsBinding;
import com.moutamid.tourismsimpleapp.model.DataModel;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class DestinationsFragment extends Fragment {

    private FragmentDestinationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDestinationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ArrayList<SlideModel> arrayList = new ArrayList<>();

        for (DataModel model : Brain.topDestinationsDataArrayList()) {
            arrayList.add(new SlideModel(model.drawable, model.title, ScaleTypes.CENTER_CROP));
        }

        /*arrayList.add(new SlideModel(R.drawable.img_1food, "", ScaleTypes.CENTER_CROP));
        arrayList.add(new SlideModel(R.drawable.img_2food, "", ScaleTypes.CENTER_CROP));
        arrayList.add(new SlideModel(R.drawable.img_3food, "", ScaleTypes.CENTER_CROP));
        arrayList.add(new SlideModel(R.drawable.img_4food, "", ScaleTypes.CENTER_CROP));
        arrayList.add(new SlideModel(R.drawable.img_5food, "", ScaleTypes.CENTER_CROP));
        arrayList.add(new SlideModel(R.drawable.img_6food, "", ScaleTypes.CENTER_CROP));
        arrayList.add(new SlideModel(R.drawable.img_7food, "", ScaleTypes.CENTER_CROP));*/

        binding.imageSlider.setImageList(arrayList);

        return root;
    }
}