package com.example.narcotixguard;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton;
import com.zegocloud.uikit.service.defines.ZegoUIKitUser;

import java.util.Collections;

public class CallActivity extends AppCompatActivity {

    EditText userIdEditText;
    TextView heyUserTextView;
    ZegoSendCallInvitationButton voiceBtn,videoBtn;

    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        userIdEditText = findViewById(R.id.user_id_edit_text);
        heyUserTextView = findViewById(R.id.hey_user_textview);
        voiceBtn = findViewById(R.id.voice_call_btn);
        videoBtn = findViewById(R.id.video_call_btn);
        startBtn=findViewById(R.id.start_btn);

        String userID = getIntent().getStringExtra("userID");
        heyUserTextView.setText("Hey"+userID);

        userIdEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String targetUserID = userIdEditText.getText().toString().trim();
                setVoiceCall(targetUserID);
                setVideoCall(targetUserID);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    void setVoiceCall(String targetUserID){
        voiceBtn.setIsVideoCall(false);
        voiceBtn.setResourceID("zego_uikit_call"); // Please fill in the resource ID name that has been configured in the ZEGOCLOUD's console here.
        voiceBtn.setInvitees(Collections.singletonList(new ZegoUIKitUser(targetUserID,targetUserID)));

    }
    void setVideoCall(String targetUserID){
        videoBtn.setIsVideoCall(true);
        videoBtn.setResourceID("zego_uikit_call"); // Please fill in the resource ID name that has been configured in the ZEGOCLOUD's console here.
        videoBtn.setInvitees(Collections.singletonList(new ZegoUIKitUser(targetUserID,targetUserID)));

    }
}