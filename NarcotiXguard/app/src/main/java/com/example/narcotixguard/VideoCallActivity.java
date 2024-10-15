package com.example.narcotixguard;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.zegocloud.uikit.prebuilt.call.config.ZegoNotificationConfig;
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig;
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationService;

public class VideoCallActivity extends AppCompatActivity {

    EditText userIdEditText;

    Button startBtn;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_video_call);

        userIdEditText = findViewById(R.id.user_id_edit_text);
        startBtn = findViewById(R.id.start_btn);


        startBtn.setOnClickListener((v) -> {

            String userID = userIdEditText.getText().toString().trim();
            if (userID.isEmpty()) {
                return;
            }
            startService(userID);
            Intent intent = new Intent(VideoCallActivity.this, CallActivity.class);
            intent.putExtra("userID",userID);
            startActivity(intent);
        });
    }

    void startService(String userID){
        Application application = getApplication();  // Android's application context
        long appID =629389291 ;   // yourAppID
        String appSign ="a5f223b93fa72212e095f9a3fff464c58588cade370bfe66b2c50fd1ef3ec82e";  // yourAppSign
        String userName =userID;   // yourUserName

        ZegoUIKitPrebuiltCallInvitationConfig callInvitationConfig = new ZegoUIKitPrebuiltCallInvitationConfig();
        ZegoNotificationConfig notificationConfig = new ZegoNotificationConfig();
        notificationConfig.sound="zego_uikit_sound_call";
        notificationConfig.channelID = "CallInvitation";
        notificationConfig.channelName="CallInvitation";

        ZegoUIKitPrebuiltCallInvitationService.init(getApplication(), appID, appSign, userID, userName,callInvitationConfig);
    }

    protected void onDestroy(){
        super.onDestroy();
        ZegoUIKitPrebuiltCallInvitationService.unInit();
    }
}