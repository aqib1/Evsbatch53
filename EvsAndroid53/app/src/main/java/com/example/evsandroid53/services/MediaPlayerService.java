package com.example.evsandroid53.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.evsandroid53.R;

public class MediaPlayerService extends Service {

    private MediaPlayer player = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startMediaPlayer();
        return START_STICKY;

    }

    private void startMediaPlayer() {
        player = MediaPlayer.create(this, R.raw.iphone_6_original);
        player.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopPlayer();
    }

    public void stopPlayer() {
        player.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
