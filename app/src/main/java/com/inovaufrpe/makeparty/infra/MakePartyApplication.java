package com.inovaufrpe.makeparty.infra;

import android.app.Application;
import android.util.Log;

public class MakePartyApplication extends Application {
    private static final String TAG = " MakePartyApplication";
    private static MakePartyApplication instance = null;
    //private Bus bus = new Bus();

    public static MakePartyApplication getInstance() {
        return instance; // Singleton
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, " MakePartyApplication.onCreate()");
        // Salva a instância para termos acesso como Singleton
        instance = this;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, " MakePartyApplication.onTerminate()");
    }

    //public Bus getBus() {
      //  return bus;
    //}
}
