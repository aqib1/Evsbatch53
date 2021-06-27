package com.example.evsandroid53.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.evsandroid53.R;

public class RegisterFragment extends Fragment {

    private Button register;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        initComponents(view);
        settingUpListener();
        return view;
    }

    private void settingUpListener() {
        register.setOnClickListener((v) -> {
            //do your code here whatever you need
        });
    }

    private void initComponents(View view) {
        register = view.findViewById(R.id.btn_signin);
    }
}
