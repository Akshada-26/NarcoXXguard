package com.example.narcotixguard;

// MainActivity.java

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;

public class VirtualMeet extends AppCompatActivity {

    private DatabaseReference databaseRef;
    private TextView textView;
    private Button videoCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virtual_meet);

        // Initialize Firebase database reference


        // Initialize TextView to display data

        videoCall=findViewById(R.id.videoCall);

        videoCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement login functionality here
                // You can use mAuth.signInWithEmailAndPassword() for authentication
                Intent intent = new Intent(VirtualMeet.this, VideoCallActivity.class);
                startActivity(intent);
            }
        });
    }
}