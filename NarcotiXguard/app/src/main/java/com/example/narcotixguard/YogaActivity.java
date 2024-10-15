package com.example.narcotixguard;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class YogaActivity extends AppCompatActivity {

    private Button startStopButton;
    private EditText minutesEditText;
    private EditText secondsEditText;
    private TextView timerTextView;
    private CountDownTimer countDownTimer;
    private boolean isTimerRunning = false;
    private WebView webView;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);

        startStopButton = findViewById(R.id.startStopButton);
        minutesEditText = findViewById(R.id.minutesEditText);
        secondsEditText = findViewById(R.id.secondsEditText);
        timerTextView = findViewById(R.id.timerTextView);



        startStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStartStopButtonClick();
            }
        });

        webView = findViewById(R.id.webView);

        // Enable JavaScript (required for YouTube embedding)
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Load YouTube video
        String youtubeVideoId = "l2reCt9rBHSeP1Yb"; // Replace with your YouTube video ID
        String youtubeUrl = "https://www.youtube.com/embed/O2RYLYqdj2M?si=" + youtubeVideoId;
        webView.loadUrl(youtubeUrl);
    }

    private void onStartStopButtonClick() {
        if (!isTimerRunning) {
            // Start the timer
            int totalMilliseconds = (Integer.parseInt(minutesEditText.getText().toString()) * 60
                    + Integer.parseInt(secondsEditText.getText().toString())) * 1000;

            countDownTimer = new CountDownTimer(totalMilliseconds, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    updateTimerText(millisUntilFinished);
                }

                @Override
                public void onFinish() {
                    onTimerFinish();
                }
            }.start();

            isTimerRunning = true;
            startStopButton.setText("Stop Timer");
        } else {
            // Stop the timer
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }

            isTimerRunning = false;
            startStopButton.setText("Start Timer");
            resetTimerText();
        }
    }

    private void updateTimerText(long millisUntilFinished) {
        long minutes = millisUntilFinished / 1000 / 60;
        long seconds = (millisUntilFinished / 1000) % 60;
        timerTextView.setText(String.format("%02d:%02d", minutes, seconds));
    }

    private void onTimerFinish() {
        // Handle actions when the timer finishes (e.g., play alarm sound)
        timerTextView.setText("00:00");
        isTimerRunning = false;
        startStopButton.setText("Start Timer");
    }

    private void resetTimerText() {
        timerTextView.setText("00:00");
    }
}
