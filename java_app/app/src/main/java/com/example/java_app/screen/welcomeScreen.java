package com.example.java_app.screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.java_app.R;

public class welcomeScreen extends AppCompatActivity {

    Button inBtn,upBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcomescreen);

        inBtn=findViewById(R.id.inBtn);
        upBtn=findViewById(R.id.upBtn);

        inBtn.setOnClickListener(v -> {

            Intent i = new Intent(welcomeScreen.this, loginScreen.class);
            startActivity(i);

        });

        upBtn.setOnClickListener(v -> {

            Intent i = new Intent(welcomeScreen.this, register.class);
            startActivity(i);

        });

    }
}