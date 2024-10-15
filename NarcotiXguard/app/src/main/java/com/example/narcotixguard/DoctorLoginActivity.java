package com.example.narcotixguard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DoctorLoginActivity extends AppCompatActivity {

    private EditText drEmail, drPassword;
    private Button drBtnLogin;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);

        drEmail = findViewById(R.id.drEmail);
        drPassword = findViewById(R.id.drPassword);
        drBtnLogin = findViewById(R.id.drBtnLogin);

        mAuth = FirebaseAuth.getInstance();

        drBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        String email = drEmail.getText().toString().trim();
        String password = drPassword.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(email, password)

                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(DoctorLoginActivity.this, "Authentication successful.",
                                    Toast.LENGTH_SHORT).show();

                            // Redirect to the doctor's home page
                            Intent intent = new Intent(DoctorLoginActivity.this, DoctorHomeActivity.class);
                            startActivity(intent);
                            finish(); // Optional, to close the current activity
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(DoctorLoginActivity.this, "Authentication failed. " + task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}

