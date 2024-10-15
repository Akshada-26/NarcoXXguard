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

public class NewPageActivity extends AppCompatActivity {

    private EditText etName, etAge, etMobile, etAddictionDetail, etDrugType, etUsername, etPassword;
    private Button btnRegister, btnBack;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_page);

        // Initialize Firebase Auth and Database
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("Patients");

        // Initialize Views
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etMobile = findViewById(R.id.etMobile);
        etAddictionDetail = findViewById(R.id.etAddictionDetail);
        etDrugType = findViewById(R.id.etDrugType);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnBack = findViewById(R.id.btnBack);

        // Handle registration button click
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerPatient();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewPageActivity.this, PatientRegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void registerPatient() {
        // Get user input from EditText fields
        String name = etName.getText().toString().trim();
        String age = etAge.getText().toString().trim();
        String mobile = etMobile.getText().toString().trim();
        String addictionDetail = etAddictionDetail.getText().toString().trim();
        String drugType = etDrugType.getText().toString().trim();
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // Validate input fields
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(age) || TextUtils.isEmpty(mobile)
                || TextUtils.isEmpty(addictionDetail) || TextUtils.isEmpty(drugType)
                || TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create Firebase Authentication user account
        mAuth.createUserWithEmailAndPassword(username + "@narcotixguard.com", password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Save patient data to Firebase Realtime Database
                            FirebaseUser user = mAuth.getCurrentUser();
                            String userId = user.getUid();

                            Patient patient = new Patient(name, age, mobile, addictionDetail, drugType,username);
                            mDatabase.child(userId).setValue(patient);

                            // Registration successful, navigate to dashboard or home activity
                            Intent intent = new Intent(NewPageActivity.this, PatientHomeActivity.class);
                            startActivity(intent);
                            finish(); // Close registration activity
                        } else {
                            // Registration failed
                            Toast.makeText(NewPageActivity.this, "Registration failed. Please try again.", Toast.LENGTH_SHORT).show();
                            Log.e("RegistrationError", "Registration failed: " + task.getException().getMessage());
                        }
                    }
                });
    }
}
