package com.gdgkazan.summer_school_2017;

import android.app.Application;

import com.gdgkazan.summer_school_2017.lessons.lesson_3.api.ApiFactory;
import com.facebook.stetho.Stetho;

/**
 * @author Timur Valiev
 */
public class AppDelegate extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
    }
}
