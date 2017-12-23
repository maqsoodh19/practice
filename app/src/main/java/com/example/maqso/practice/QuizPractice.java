package com.example.maqso.practice;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.drm.DrmStore;
import android.net.nsd.NsdManager;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizPractice extends AppCompatActivity {


    private static final String TAG = "MYTAG";
    TextView name, password;
    String nameCheck;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_practice);
        login = (Button) findViewById(R.id.btnLogin);
        name = (TextView) findViewById(R.id.txtName);
        password = (TextView) findViewById(R.id.txtPassword);
        final SharedPreferences preferences = getSharedPreferences("logging", MODE_PRIVATE);

        final SharedPreferences.Editor editor = preferences.edit();
        nameCheck = preferences.getString("name", null);

        if (nameCheck != null) {

            Intent i = new Intent(QuizPractice.this, WelcomeActivity.class);
            startActivity(i);

        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("name", name.getText().toString());
                editor.putString("password", password.getText().toString());
                editor.apply();
                Intent i = new Intent(QuizPractice.this, WelcomeActivity.class);
                startActivity(i);
            }
        });

    }

                                        // Broadcast receiver practice
    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int state = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
            Log.d(TAG, "onReceive: Battery state:  "+ state);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onPause() {
        if (receiver != null) {
            unregisterReceiver(receiver);
            receiver = null;
        }

        super.onPause();
    }


}
