package com.example.evsandroid53.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import java.util.Objects;

public class FManager {
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private static FManager fManager = null;

    public FManager init(Activity activity) {
        fragmentManager = activity.getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        return fManager;
    }

    public FManager add(Fragment fragment) {
        transaction.add(fragment, fragment.getClass().getName());
        transaction.commit();
        return fManager;
    }

    public FManager remove(Fragment fragment) {
        transaction.remove(fragment);
        transaction.commit();
        return fManager;
    }

    public FManager replace(int layout, Fragment fragment) {
        transaction.replace(layout, fragment);
        transaction.commit();
        return fManager;
    }

    // Singleton
    public static FManager getInstance() {
        if(Objects.isNull(fManager)) {
            //t1, t2
            synchronized (FManager.class) {
                if(Objects.isNull(fManager)) {
                    fManager = new FManager();
                }
            }
        }
        return fManager;
    }

    private FManager() {

    }
}
