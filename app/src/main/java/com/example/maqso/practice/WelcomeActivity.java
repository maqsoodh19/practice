package com.example.maqso.practice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    TextView name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        name = (TextView) findViewById(R.id.txtNameShow);
        password = (TextView) findViewById(R.id.txtPasswordShow);

        final SharedPreferences preferences = getSharedPreferences("logging", MODE_PRIVATE);
        name.setText(preferences.getString("name", "User Name"));
        password.setText(preferences.getString("password", "User Password"));


        findViewById(R.id.btnLogOut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(WelcomeActivity.this,QuizPractice.class));
            }
        });
    }
}
