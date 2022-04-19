package com.moutamid.tourismsimpleapp.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.moutamid.tourismsimpleapp.MainActivity;
import com.moutamid.tourismsimpleapp.NavigationDrawerActivity;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startActivity(new Intent(this, NavigationDrawerActivity.class));

    }
}
