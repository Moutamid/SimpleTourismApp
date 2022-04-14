package com.moutamid.tourismsimpleapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.fxn.stash.Stash;
import com.moutamid.tourismsimpleapp.R;
import com.moutamid.tourismsimpleapp.databinding.ActivitySingleItemBinding;
import com.moutamid.tourismsimpleapp.model.DataModel;
import com.moutamid.tourismsimpleapp.utils.Constants;

public class SingleItemActivity extends AppCompatActivity {
    private ActivitySingleItemBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivitySingleItemBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        DataModel model = (DataModel) Stash.getObject(Constants.SAVED_OBJECT, DataModel.class);

        b.imageviewsingleitem.setImageResource(model.drawable);

        b.titlesingleitem.setText(model.title);

        b.descsingleitem.setText(model.desc);

    }
}