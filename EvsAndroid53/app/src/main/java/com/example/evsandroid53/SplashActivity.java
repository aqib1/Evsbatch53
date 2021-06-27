package com.example.evsandroid53;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

// -> setup database
// -> load config
// -> user permissions
// ->3s 5s 8s
public class SplashActivity extends Activity {

    ///
    ///

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        waitingForSplash();
    }

    private void waitingForSplash() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                Toast.makeText(this, "Calling main activity", Toast.LENGTH_LONG).show();
                Intent intent = new Intent("com.example.evsandroid53.MAINACTIVITY");
                startActivity(intent);
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}
