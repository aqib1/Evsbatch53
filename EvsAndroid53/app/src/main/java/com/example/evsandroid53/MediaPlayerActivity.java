package com.example.evsandroid53;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ToggleButton;

import com.example.evsandroid53.services.MediaPlayerService;

public class MediaPlayerActivity extends Activity {

    private ToggleButton tb_media_player;
    private final Intent musicIntent = new Intent(MediaPlayerActivity.this, MediaPlayerService.class);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponents();
        settingUpListener();
    }

    private void settingUpListener() {
        tb_media_player.setOnClickListener((v) -> {
            if(tb_media_player.isChecked()) {
                startService(musicIntent);
            } else {
                stopService(musicIntent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(musicIntent);
    }

    private void initComponents() {
        tb_media_player = findViewById(R.id.tb_media_player);
    }


}
