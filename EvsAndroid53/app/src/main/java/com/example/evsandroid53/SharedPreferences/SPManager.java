package com.example.evsandroid53.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Objects;

public class SPManager {
    private static SPManager spManager;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SPManager init(String name, Context context) {
        sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        return spManager;
    }

    public SPManager addString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
        return spManager;
    }

    public String readString(String key) {
        return sharedPreferences.getString(key, "Key Not Found");
    }

    public static SPManager getInstance() {
        if(Objects.isNull(spManager)) {
            synchronized (SPManager.class) {
                if(Objects.isNull(spManager))
                    spManager = new SPManager();
            }
        }
        return spManager;
    }

    private SPManager() {

    }
}
