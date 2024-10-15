package com.example.narcotixguard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

public class PatientRegistrationActivity extends AppCompatActivity {


    private EditText etName, etAge, etMobile, etAddictionDetails, etAddictionYear, etDrugType, etPassword;
    private Button btnRegister, btnLogin, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_registration);

        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);
        btnBack = findViewById(R.id.btnBack);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle registration logic

                // After successful registration, navigate to the new page
                navigateToNewPage();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement login functionality here
                // You can use mAuth.signInWithEmailAndPassword() for authentication
                openLoginActivity();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PatientRegistrationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }

    private void navigateToNewPage() {
        Intent intent = new Intent(this, NewPageActivity.class);
        startActivity(intent);
        // Optional: If you want to finish the current activity so that pressing back won't return to it
        finish();
    }

    private void openLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
