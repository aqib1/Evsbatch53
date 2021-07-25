package com.example.evsandroid53;

import android.Manifest;

public final class Constants {

    public static final String initAddr="http://192.168.15.171/API/api_batch14_get.php?";
    public static final String initAddr_POST="http://192.168.15.171/API/api_batch14_post.php";

    public static final int RUNTIME_PERMISSION_REQUEST_CODE_FOR_TORCH = 0;
    public static final String[] TORCH_ACTIVITY_PERMISSIONS = {Manifest.permission.CAMERA};

    private Constants() {

    }
}
