package com.example.java_app.screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.java_app.MainActivity;
import com.example.java_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginScreen extends AppCompatActivity {
    TextView upTxt;
    CardView inBtn;
    EditText editTextEmail,editTextPassword;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){

            Intent i = new Intent(loginScreen.this, MainActivity.class);
            startActivity(i);
            finish();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loginscreen);
        mAuth =FirebaseAuth.getInstance();

        upTxt=findViewById(R.id.upTxt);
        inBtn=findViewById(R.id.inBtn);



        progressBar=findViewById(R.id.pro);


        editTextEmail=findViewById(R.id.email);
        editTextPassword=findViewById(R.id.password);




        inBtn.setOnClickListener(v -> {

            progressBar.setVisibility(View.VISIBLE);

            String email,password;
            email = editTextEmail.getText().toString();
            password = editTextPassword.getText().toString();

            if(email.isEmpty()){
                Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show();
                return;
            }

            if(password.isEmpty()){
                Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
                return;
            }


            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {

                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {

                            Toast.makeText(loginScreen.this, "Login Successful",
                                    Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(loginScreen.this, MainActivity.class);
                            startActivity(i);
                            finish();


                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(loginScreen.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    });



        });




        upTxt.setOnClickListener(v -> {

            Intent i = new Intent(loginScreen.this, register.class);
            startActivity(i);

        });




    }
}