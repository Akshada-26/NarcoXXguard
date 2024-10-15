package com.example.narcotixguard;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DoctorRegisterActivity extends AppCompatActivity {

    private EditText etName, etSpecialization, etDegree, etEmail, etPassword;
    private Button btnRegister;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_register);

        // Initialize Firebase Auth and Database
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("Doctors");

        // Initialize Views
        etName = findViewById(R.id.etName);
        etSpecialization = findViewById(R.id.etSpecialization);
        etDegree = findViewById(R.id.etDegree);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);

        // Handle registration button click
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerDoctor();
            }
        });
    }

    private void registerDoctor() {
        // Get user input from EditText fields
        String name = etName.getText().toString().trim();
        String specialization = etSpecialization.getText().toString().trim();
        String degree = etDegree.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // Validate input fields
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(specialization) || TextUtils.isEmpty(degree)
                || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create Firebase Authentication user account
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Save doctor data to Firebase Realtime Database
                            FirebaseUser user = mAuth.getCurrentUser();
                            String userId = user.getUid();

                            Doctor doctor = new Doctor(name, specialization, degree, email);
                            mDatabase.child(userId).setValue(doctor);

                            // Registration successful, navigate to doctor home activity
                            Intent intent = new Intent(DoctorRegisterActivity.this, DoctorHomeActivity.class);
                            startActivity(intent);
                            finish(); // Close registration activity
                        } else {
                            // Registration failed
                            Toast.makeText(DoctorRegisterActivity.this, "Registration failed. Please try again.", Toast.LENGTH_SHORT).show();
                            Log.e("RegistrationError", "Registration failed: " + task.getException().getMessage());
                        }
                    }
                });
    }
}