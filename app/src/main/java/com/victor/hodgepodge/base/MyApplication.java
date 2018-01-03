package com.victor.hodgepodge.base;

import android.app.Application;
import android.util.Log;

import com.facebook.stetho.Stetho;
import com.victor.hodgepodge.BuildConfig;

/**
 * Created by victor on 17-9-26.
 */

public class MyApplication extends Application {
    private static final String TAG = "MyApplication";

    private static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Log.i(TAG, " --> DEBUG : " + BuildConfig.DEBUG);
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
    }

}
