package com.moutamid.tourismsimpleapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fxn.stash.Stash;
import com.moutamid.tourismsimpleapp.databinding.ActivityLoginBinding;
import com.moutamid.tourismsimpleapp.model.UserModel;
import com.moutamid.tourismsimpleapp.utils.Constants;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        if (Stash.getBoolean(Constants.IS_LOGGED_IN, false)) {
            b.loginlayout.setVisibility(View.GONE);
            b.logintext.setVisibility(View.VISIBLE);
            return;
        }

        b.loginbtn.setOnClickListener(listener(true));
        b.signupbtn.setOnClickListener(listener(false));


    }

    private View.OnClickListener listener(boolean isLogin) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = b.email.getText().toString().toLowerCase().trim();
                String password = b.password.getText().toString().toLowerCase().trim();

                if (email.isEmpty())
                    return;
                if (password.isEmpty())
                    return;

                ArrayList<UserModel> users = Stash.getArrayList(Constants.USERS_LIST, UserModel.class);

                if (isLogin) {
                    if (users.size() > 0) {
                        for (UserModel model : users) {
                            if (model.email.equals(email)) {
                                if (model.password.equals(password)) {
                                    // LOGIN SUCCESS
                                    Toast.makeText(LoginActivity.this, "You have been signed in successfully!", Toast.LENGTH_SHORT).show();
                                    b.loginlayout.setVisibility(View.GONE);
                                    b.logintext.setVisibility(View.VISIBLE);
                                    Stash.put(Constants.IS_LOGGED_IN, true);
                                    break;
                                } else
                                    Toast.makeText(LoginActivity.this, "Password is wrong!", Toast.LENGTH_SHORT).show();
                            } else
                                Toast.makeText(LoginActivity.this, "Email not found!", Toast.LENGTH_SHORT).show();
                        }
                    } else
                        Toast.makeText(LoginActivity.this, "Email not found!", Toast.LENGTH_SHORT).show();

                } else {
                    // SIGN UP SUCCESS
                    users.add(new UserModel(email, password));
                    Stash.put(Constants.USERS_LIST, users);
                    Toast.makeText(LoginActivity.this, "You have been signed up successfully!", Toast.LENGTH_SHORT).show();
                    b.loginlayout.setVisibility(View.GONE);
                    b.logintext.setVisibility(View.VISIBLE);
                    Stash.put(Constants.IS_LOGGED_IN, true);
                }

            }
        };
    }
}