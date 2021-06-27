package com.example.evsandroid53.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.evsandroid53.R;
import com.example.evsandroid53.SharedPreferences.SPManager;
import com.example.evsandroid53.db.helper.db.UserDbHelper;
import com.example.evsandroid53.entities.User;

public class SigninFragment extends Fragment {

    private static final String SIGN_IN_SHARED_PREFERENCE_NAME = "SIGN_IN_SHARED_PREFERENCE_NAME";
    private Button signin;
    private EditText password;
    private EditText userName;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signin, container, false);
        initComponents(view);
        settingUpListener();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void settingUpListener() {
        signin.setOnClickListener((v) -> {
            //do your code here whatever you need
//            SPManager.getInstance().addString("password", password.getText().toString());
            UserDbHelper userDbHelper = new UserDbHelper(getContext());
            User user = new User();
            user.setUserName(userName.getText().toString());
            user.setUserPassword(password.getText().toString());
            userDbHelper.insert(user);
            userDbHelper.close();
        });


//        SPManager.getInstance().readString("password");
    }

    private void initComponents(View view) {
        signin = view.findViewById(R.id.btn_signin);
        password = view.findViewById(R.id.pwd_edit_text);
        userName = view.findViewById(R.id.username_edit_text);
        SPManager.getInstance().init(SIGN_IN_SHARED_PREFERENCE_NAME, getActivity().getBaseContext());
    }
}
