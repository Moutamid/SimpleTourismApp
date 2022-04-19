package com.moutamid.tourismsimpleapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.fxn.stash.Stash;
import com.moutamid.tourismsimpleapp.activities.AllItemsActivity;
import com.moutamid.tourismsimpleapp.activities.SingleItemActivity;
import com.moutamid.tourismsimpleapp.brain.Brain;
import com.moutamid.tourismsimpleapp.databinding.FragmentEventsBinding;
import com.moutamid.tourismsimpleapp.model.DataModel;
import com.moutamid.tourismsimpleapp.utils.Constants;

import java.util.ArrayList;

public class EventsFragment extends Fragment {

    private FragmentEventsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEventsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ArrayList<SlideModel> arrayList = new ArrayList<>();

        for (DataModel model : Brain.eventsDataArrayList()) {
            arrayList.add(new SlideModel(model.drawable, model.title, ScaleTypes.CENTER_CROP));
        }

        binding.imageSlider.setImageList(arrayList);

        binding.allitemscard.setOnClickListener(listener());
        binding.allitemsbtn.setOnClickListener(listener());

        binding.imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {
                Stash.put(Constants.SAVED_OBJECT, Brain.eventsDataArrayList().get(i));
                startActivity(new Intent(requireActivity(), SingleItemActivity.class));
            }
        });

        binding.card1.setOnClickListener(view -> {
            Stash.put(Constants.SAVED_OBJECT, Brain.eventsDataArrayList().get(0));
            startActivity(new Intent(requireActivity(), SingleItemActivity.class));
        });

        binding.card2.setOnClickListener(view -> {
            Stash.put(Constants.SAVED_OBJECT, Brain.eventsDataArrayList().get(0));
            startActivity(new Intent(requireActivity(), SingleItemActivity.class));
        });

        return root;
    }

    private View.OnClickListener listener() {
        return view -> {
            startActivity(new Intent(requireActivity(), AllItemsActivity.class)
                    .putExtra(Constants.PARAMS, Constants.EVENTS));
        };
    }
}