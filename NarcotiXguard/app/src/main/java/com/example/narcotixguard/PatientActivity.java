package com.example.narcotixguard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PatientActivity extends AppCompatActivity {

    private Button startActivity1Button;

    private Button startActivity3Button;
    private Button startActivity4Button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_activity);

        startActivity1Button = findViewById(R.id.startActivity1Button);
        startActivity3Button = findViewById(R.id.startActivity3Button);
        startActivity4Button = findViewById(R.id.startActivity4Button);


        startActivity1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PatientActivity.this, MindfulnessMeditationActivity.class));

            }
        });


        startActivity3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PatientActivity.this, YogaActivity.class));

            }
        });

        startActivity4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PatientActivity.this, DeepBreathingActivity.class));

            }
        });


    }

}
