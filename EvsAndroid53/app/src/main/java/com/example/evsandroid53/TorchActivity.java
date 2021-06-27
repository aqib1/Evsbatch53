package com.example.evsandroid53;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;
import android.widget.ToggleButton;

import static com.example.evsandroid53.Constants.RUNTIME_PERMISSION_REQUEST_CODE_FOR_TORCH;
import static com.example.evsandroid53.Constants.TORCH_ACTIVITY_PERMISSIONS;

public class TorchActivity extends Activity {

    private ToggleButton tb_torch;
    private CameraManager cameraManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch);
        addingRuntimePermissions();
        initComponents();
        setOnClickListener();
    }

    private void setOnClickListener() {
        tb_torch.setOnClickListener((v) -> {
            if (tb_torch.isChecked()) {
                torchOn();
            } else {
                torchOff();
            }
        });
    }

    private void torchOn() {
        try {
            cameraManager.setTorchMode(cameraManager.getCameraIdList()[0], true);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

    }

    private void torchOff() {
        try {
            cameraManager.setTorchMode(cameraManager.getCameraIdList()[0], false);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {
        tb_torch = findViewById(R.id.tb_torch);
        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(tb_torch.isChecked()) {
            torchOff();
            tb_torch.setChecked(false);
        }
    }

    private void addingRuntimePermissions() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, TORCH_ACTIVITY_PERMISSIONS, RUNTIME_PERMISSION_REQUEST_CODE_FOR_TORCH);
            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case RUNTIME_PERMISSION_REQUEST_CODE_FOR_TORCH: {
               if(grantResults.length > 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                   Toast.makeText(this, "This application can not be used without camera permissions", Toast.LENGTH_LONG).show();
                    finish();
               }
            }

        }
     }

}
