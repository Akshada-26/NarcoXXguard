package com.example.narcotixguard;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class AwarenessActivity extends AppCompatActivity {

    private WebView webView;
    private WebView webView1;
    private WebView webView2;
    private WebView webView3;
    private WebView webView4;
    private WebView webView5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awareness);

        webView = findViewById(R.id.webView);
        webView1 = findViewById(R.id.webView1);
        webView2 = findViewById(R.id.webView2);
        webView3 = findViewById(R.id.webView3);
        webView4 = findViewById(R.id.webView4);
        webView5 = findViewById(R.id.webView5);



        // Enable JavaScript (required for YouTube embedding)
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        // Load YouTube video
        String youtubeVideoId = "rJhiJQFReOsbxNAZ"; // Replace with your YouTube video ID
        String youtubeUrl = "https://www.youtube.com/embed/wQl_4kcE5nw?si=" + youtubeVideoId;
        webView.loadUrl(youtubeUrl);

        WebSettings webSettings1 = webView1.getSettings();
        webSettings1.setJavaScriptEnabled(true);

        String youtubeVideoId1 = "8BLF6od35p7gNMkh"; // Replace with your YouTube video ID
        String youtubeUrl1 = "https://www.youtube.com/embed/p2ZT0lnbQLU?si=" + youtubeVideoId1;
        webView1.loadUrl(youtubeUrl1);

        WebSettings webSettings2 = webView2.getSettings();
        webSettings2.setJavaScriptEnabled(true);

        String youtubeVideoId2 = "pmPWMyoNJrQrZDHa"; // Replace with your YouTube video ID
        String youtubeUrl2 = "https://www.youtube.com/embed/NxHNxmJv2bQ?si=" + youtubeVideoId2;
        webView2.loadUrl(youtubeUrl2);

        WebSettings webSettings3 = webView3.getSettings();
        webSettings3.setJavaScriptEnabled(true);

        String youtubeVideoId3 = "UDTdlQ9mRxtDAQJ7"; // Replace with your YouTube video ID
        String youtubeUrl3 = "https://www.youtube.com/embed/RczTGWQ6sb4?si=" + youtubeVideoId3;
        webView3.loadUrl(youtubeUrl3);

        WebSettings webSettings4 = webView4.getSettings();
        webSettings4.setJavaScriptEnabled(true);

        String youtubeVideoId4 = "5fbUbS_bmzMprMY_"; // Replace with your YouTube video ID
        String youtubeUrl4 = "https://www.youtube.com/embed/shtRXgefI9U?si=" + youtubeVideoId4;
        webView4.loadUrl(youtubeUrl4);

        WebSettings webSettings5 = webView5.getSettings();
        webSettings5.setJavaScriptEnabled(true);

        String youtubeVideoId5 = "O9CUW7uLX38Qy_bN"; // Replace with your YouTube video ID
        String youtubeUrl5 = "https://www.youtube.com/embed/lfapxZUTiCU?si=" + youtubeVideoId5;
        webView5.loadUrl(youtubeUrl5);
    }
}