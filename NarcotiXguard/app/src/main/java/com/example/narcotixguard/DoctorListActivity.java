package com.example.narcotixguard;

// MainActivity.java
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DoctorListActivity extends AppCompatActivity {

    private DatabaseReference databaseRef;
    private TextView textView;
    private Button videoCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        // Initialize Firebase database reference
        databaseRef = FirebaseDatabase.getInstance().getReference().child("Doctors");

        // Initialize TextView to display data
        textView = findViewById(R.id.textView);
        videoCall=findViewById(R.id.videoCall);

        videoCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement login functionality here
                // You can use mAuth.signInWithEmailAndPassword() for authentication
                Intent intent = new Intent(DoctorListActivity.this, VideoCallActivity.class);
                startActivity(intent);
            }
        });

        // Add ValueEventListener to fetch data
        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Clear previous data
                textView.setText("");

                // Iterate through all the children (tuples) under this reference
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String userId = snapshot.getKey();
                    // Get the value of the tuple

                    Object tuple = snapshot.getValue();

                    // Display tuple data on the screen
                    //textView.append("Tuple data:\n");
                    //textView.append("UserID: " + userId + "\n");
                    textView.append("Data: " + tuple.toString() + "\n");
                    /*textView.append("Degree: " + tuple.getDegree() + "\n");
                    textView.append("Name: " + tuple.getName() + "\n");
                    textView.append("Specialization: " + tuple.getSpecialization() + "\n");

                    textView.append("Name: " + tuple.getEmail() + "\n");
                    textView.setText("Degree: " + tuple.getDegree() + "\n"
                            + "Name: " + tuple.getName() + "\n"
                            +"Specialization: " + tuple.getSpecialization()  +"\n");
                    // Add more fields as needed
                    */


                    // Add a separator between tuples
                    textView.append("\n");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors
                Log.e("FirebaseError", "Error fetching data", databaseError.toException());
            }
        });
    }
}
