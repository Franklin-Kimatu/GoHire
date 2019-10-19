package com.moringa.gohire.ui.main;

import android.app.Application;

import com.firebase.client.Firebase;

public class Gohire extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
