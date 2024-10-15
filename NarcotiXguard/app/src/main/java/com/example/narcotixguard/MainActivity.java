package com.example.narcotixguard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // final int SPLASH_DURATION = 2000; // 2 seconds

        //ImageView splashLogo = findViewById(R.id.splashLogo);
        Button patientButton = findViewById(R.id.patientButton);
        Button doctorButton = findViewById(R.id.doctorButton);


      /*  // Load the fade-in animation
        Animation fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);

        // Apply the animation to the logo
        splashLogo.startAnimation(fadeIn);
        splashLogo.setVisibility(ImageView.VISIBLE);

        // Handler to move to the main screen after the splash screen duration
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(MainActivity.this, MainScreenActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DURATION);
        
       */

        patientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PatientRegistrationActivity.class));
            }
        });

        doctorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DoctorRegistrationActivity.class));
            }
        });


    }
}
