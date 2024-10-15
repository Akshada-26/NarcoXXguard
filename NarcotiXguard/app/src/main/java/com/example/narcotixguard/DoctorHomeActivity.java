package com.example.narcotixguard;

// DoctorActivity.java

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DoctorHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);
    }

    // Handle virtual consultation button click
    public void onVirtualConsultationButtonClick(View view) {
        // Start virtual consultation activity
        Intent intent = new Intent(DoctorHomeActivity.this, VirtualMeet.class);
        startActivity(intent);
    }

    // Handle physical consultation button click
    public void onPhysicalConsultationButtonClick(View view) {
        // Start physical consultation activity
        //Intent intent = new Intent(this, PhysicalConsultationActivity.class);
        //startActivity(intent);
    }
}
