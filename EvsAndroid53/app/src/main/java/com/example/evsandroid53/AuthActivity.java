package com.example.evsandroid53;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.example.evsandroid53.fragments.FManager;
import com.example.evsandroid53.fragments.RegisterFragment;
import com.example.evsandroid53.fragments.SigninFragment;

public class AuthActivity extends Activity {
    private Button singinFrag, registerFrag;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_activity);
        initComponents();
        settingUpListeners();
    }

    private void settingUpListeners() {
        singinFrag.setOnClickListener((v) -> {
            SigninFragment signinFragment = new SigninFragment();
            FManager.getInstance()
                    .init(AuthActivity.this)
                    .replace(R.id.auth_layout, signinFragment);
        });

        registerFrag.setOnClickListener((v) -> {
            RegisterFragment registerFragment = new RegisterFragment();
            FManager.getInstance()
                    .init(AuthActivity.this)
                    .replace(R.id.auth_layout, registerFragment);
        });
    }

    private void initComponents() {
        singinFrag = findViewById(R.id.btn_frag_signin);
        registerFrag = findViewById(R.id.btn_frag_register);
    }

}
