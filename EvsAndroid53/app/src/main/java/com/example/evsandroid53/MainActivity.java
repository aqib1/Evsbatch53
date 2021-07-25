package com.example.evsandroid53;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.view.View;
import android.widget.Toast;

import com.example.evsandroid53.db.helper.db.UserDbHelper;
import com.example.evsandroid53.entities.User;

public class MainActivity extends Activity {
//    private Button clickMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        settingUpListeners();
    }

    private void settingUpListeners() {
//        clickMe.setOnClickListener(v ->
//                Toast.makeText(this, "Hi there !!!", Toast.LENGTH_LONG).show());
    }

    private void initComponents() {
//        UserDbHelper userDbHelper = new UserDbHelper(this);
//        User user = new User();
//        user.setUserName(userName.getText().toString());
//        user.setUserPassword(password.getText().toString());
//        userDbHelper.insert(user);
//        userDbHelper.close();
//        clickMe = findViewById(R.id.clickMe);

        SMSManager.getInstance().init().sendMessage("", "", "");
    }

//    public void clickMe(View view) {
//        Toast.makeText(this, "Hi there !!!", Toast.LENGTH_LONG).show();
//    }
}