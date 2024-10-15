package com.example.narcotixguard;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PatientDashboardActivity extends AppCompatActivity {

    private TextView tvPatientName, tvAge, tvMobile, tvAddictionDetails, tvDrugType;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_dashboard);

        // Initialize Firebase
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser=mAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference("Patients");

        // Initialize TextViews
        tvPatientName = findViewById(R.id.tvPatientName);
        tvAge = findViewById(R.id.tvAge);
        tvMobile = findViewById(R.id.tvMobile);
        tvAddictionDetails = findViewById(R.id.tvAddictionDetails);
        tvDrugType = findViewById(R.id.tvDrugType);

        // Check if the current user is not null
        if (currentUser != null) {
            // Get the username from the current user's patient data in the database
            String userId = currentUser.getUid();

            // Query the database to get the patient data for the current user
            DatabaseReference userRef = mDatabase.child(userId);

            userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        // Retrieve patient data from the database
                        String username = dataSnapshot.child("username").getValue(String.class);
                        String name = dataSnapshot.child("name").getValue(String.class);
                        String age = dataSnapshot.child("age").getValue(String.class);
                        String mobile = dataSnapshot.child("mobile").getValue(String.class);
                        String addictionDetail = dataSnapshot.child("addictionDetail").getValue(String.class);
                        String drugType = dataSnapshot.child("drugType").getValue(String.class);

                        // Set retrieved data to TextViews
                        tvPatientName.setText(name);
                        tvAge.setText(age);
                        tvMobile.setText(mobile);
                        tvAddictionDetails.setText(addictionDetail);
                        tvDrugType.setText(drugType);
                    } else {
                        // Handle the case when the patient data for the current user does not exist
                        Toast.makeText(getApplicationContext(), "Patient data not found.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle data retrieval failure
                    Log.e("FirebaseError", "Data retrieval canceled: " + databaseError.getMessage());
                    Toast.makeText(getApplicationContext(), "Failed to retrieve data. Please try again later.", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            // Handle the case when the current user is null (not authenticated)
            // You may want to redirect the user to the login screen or take appropriate action
            Toast.makeText(this, "User not authenticated. Please log in.", Toast.LENGTH_SHORT).show();
            // Redirect to login screen
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            // Finish the current activity
            finish();
        }





        // Initialize views
        Button btnMeeting = findViewById(R.id.btnMeeting);
        Button btnPrescription = findViewById(R.id.btnPrescription);
        Button btnPayment = findViewById(R.id.btnPayment);
        //Button btnChatBot = findViewById(R.id.btnChatBot);

        // Set onClick listeners for buttons
        btnMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMeetingButtonClick(view);
                Intent intent = new Intent(PatientDashboardActivity.this, VirtualMeet.class);
                startActivity(intent);
            }
        });

        btnPrescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPrescriptionButtonClick(view);
            }
        });

        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPaymentButtonClick(view);
            }
        });


    }



    // Button click methods
    public void onMeetingButtonClick(View view) {
        // Handle meeting button click
        Toast.makeText(this, "Schedule Meeting Clicked", Toast.LENGTH_SHORT).show();
    }

    public void onPrescriptionButtonClick(View view) {
        // Handle prescription button click
        Toast.makeText(this, "Prescription Clicked", Toast.LENGTH_SHORT).show();
    }

    public void onPaymentButtonClick(View view) {
        // Handle payment button click
        Toast.makeText(this, "Make Payment Clicked", Toast.LENGTH_SHORT).show();
    }




    public void onHomeButtonClick(View view) {
        // Handle home button click
        Toast.makeText(this, "Home Clicked", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, PatientHomeActivity.class);
        startActivity(intent);
    }

    public void onDashboardButtonClick(View view) {
        // Handle dashboard button click
        Toast.makeText(this, "Dashboard Clicked", Toast.LENGTH_SHORT).show();
    }
}
