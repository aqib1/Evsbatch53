package com.example.evsandroid53;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.view.View;
import android.widget.Toast;

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
//        clickMe = findViewById(R.id.clickMe);
    }

//    public void clickMe(View view) {
//        Toast.makeText(this, "Hi there !!!", Toast.LENGTH_LONG).show();
//    }
}