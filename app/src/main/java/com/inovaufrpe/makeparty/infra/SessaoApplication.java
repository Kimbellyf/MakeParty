package com.inovaufrpe.makeparty.infra;

import android.app.Application;
import android.util.Log;

import com.squareup.otto.Bus;

import java.util.HashMap;
import java.util.Map;

public class SessaoApplication extends Application {

    private static final String TAG = " SessaoApplication";
    private static SessaoApplication instance = null;
    private final Map<String, Object> values = new HashMap<>();
    private Bus bus = new Bus();

    public static SessaoApplication getInstance() {
        return instance; // Singleton
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, " SessaoApplication.onCreate()");
        // Salva a instância para termos acesso como Singleton
        instance = this;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, " SessaoApplication.onTerminate()");
    }

    public Bus getBus() {
        return bus;
    }
}
