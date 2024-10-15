package com.example.narcotixguard;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PatientHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home);

        // Additional initialization if needed
    }

    // Button click handlers
    public void onDoctorButtonClick(View view) {
        applyButtonClickAnimation(view);
        // TODO: Handle Doctor button click
        Intent intent = new Intent(PatientHomeActivity.this, DoctorListActivity.class);
        startActivity(intent);


    }

    public void onActivityButtonClick(View view) {
        applyButtonClickAnimation(view);
        // TODO: Handle Activity button click
        Intent intent = new Intent(PatientHomeActivity.this, PatientActivity.class);
        startActivity(intent);
    }

    public void onAwarenessButtonClick(View view) {
        applyButtonClickAnimation(view);
        // TODO: Handle Awareness button click
        Intent intent = new Intent(PatientHomeActivity.this, AwarenessActivity.class);
        startActivity(intent);
    }

    public void onHomeButtonClick(View view) {
        applyButtonClickAnimation(view);
        // TODO: Handle Home button click
    }

    public void onDashboardButtonClick(View view) {
        applyButtonClickAnimation(view);
        // TODO: Handle Dashboard button click
        Intent intent = new Intent(this, PatientDashboardActivity.class);
        startActivity(intent);
    }

    // Apply a 3D-like animation on button click
    private void applyButtonClickAnimation(View view) {
        view.animate()
                .scaleX(0.95f)
                .scaleY(0.95f)
                .setDuration(100)
                .withEndAction(() ->
                        view.animate()
                                .scaleX(1.0f)
                                .scaleY(1.0f)
                                .setDuration(100)
                );
    }
}