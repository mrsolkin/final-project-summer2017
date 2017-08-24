package com.gdgkazan.summer_school_2017;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class AppDelegate extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
    }
}
