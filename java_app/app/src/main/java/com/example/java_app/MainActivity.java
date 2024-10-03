package com.example.java_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.java_app.screen.loginScreen;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.ktx.Firebase;

public class MainActivity extends AppCompatActivity {

    ImageView logout_btn;
    FirebaseAuth auth;
    FirebaseUser user;
    TextView user_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        auth=FirebaseAuth.getInstance();

        logout_btn = findViewById(R.id.logout_btn);
        user_detail = findViewById(R.id.user_detail);

        user = auth.getCurrentUser();

        if (user==null){

            Intent i = new Intent(MainActivity.this, loginScreen.class);
            startActivity(i);
            finish();

        }else {
             user_detail.setText(user.getEmail());
        }

        logout_btn.setOnClickListener(v ->{
            FirebaseAuth.getInstance().signOut();
            Intent i = new Intent(MainActivity.this, loginScreen.class);
            startActivity(i);
            finish();
                }


        );

//                Toast.makeText(MainActivity.this, "Logout Successfully", Toast.LENGTH_SHORT).show());

    }
}