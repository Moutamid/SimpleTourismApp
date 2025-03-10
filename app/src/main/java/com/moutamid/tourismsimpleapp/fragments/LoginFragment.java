package com.moutamid.tourismsimpleapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.fxn.stash.Stash;
import com.moutamid.tourismsimpleapp.databinding.FragmentLoginBinding;
import com.moutamid.tourismsimpleapp.model.UserModel;
import com.moutamid.tourismsimpleapp.utils.Constants;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding b;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        b = FragmentLoginBinding.inflate(inflater, container, false);
        View root = b.getRoot();

        if (Stash.getBoolean(Constants.IS_LOGGED_IN, false)) {
            b.loginlayout.setVisibility(View.GONE);
            b.logintext.setVisibility(View.VISIBLE);
            return root;
        }

        b.loginbtn.setOnClickListener(listener(true));
        b.signupbtn.setOnClickListener(listener(false));

        return root;
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
                                    Toast.makeText(requireContext(), "You have been signed in successfully!", Toast.LENGTH_SHORT).show();
                                    b.loginlayout.setVisibility(View.GONE);
                                    b.logintext.setVisibility(View.VISIBLE);
                                    Stash.put(Constants.IS_LOGGED_IN, true);
                                    break;
                                } else
                                    Toast.makeText(requireContext(), "Password is wrong!", Toast.LENGTH_SHORT).show();
                            } else
                                Toast.makeText(requireContext(), "Email not found!", Toast.LENGTH_SHORT).show();
                        }
                    } else
                        Toast.makeText(requireContext(), "Email not found!", Toast.LENGTH_SHORT).show();

                } else {
                    // SIGN UP SUCCESS
                    users.add(new UserModel(email, password));
                    Stash.put(Constants.USERS_LIST, users);
                    Toast.makeText(requireContext(), "You have been signed up successfully!", Toast.LENGTH_SHORT).show();
                    b.loginlayout.setVisibility(View.GONE);
                    b.logintext.setVisibility(View.VISIBLE);
                    Stash.put(Constants.IS_LOGGED_IN, true);
                }

            }
        };
    }

}