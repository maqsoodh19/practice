package com.example.maqso.practice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;



public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        int status = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
        Log.d("MYTAG", "onReceive: AIRPLANE MODE;  "+ status);

    }
}
