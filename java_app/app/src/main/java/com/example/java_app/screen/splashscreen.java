package com.example.java_app.screen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.java_app.R;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splashscreen);


        new Handler().postDelayed(() -> {
            Intent i = new Intent(splashscreen.this, welcomeScreen.class);
            startActivity(i);
            finish();
        }, 1500);

    }
}