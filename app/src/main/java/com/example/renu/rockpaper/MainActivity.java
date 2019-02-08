package com.example.renu.rockpaper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
FirebaseDatabase db=FirebaseDatabase.getInstance();
//we have just reached to link
    DatabaseReference rootRef=db.getReference();
    DatabaseReference gameRef=rootRef.child("game");
    TextView textView;
    Button rock,paper,scissor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //rootRef.child("User").child("01").child("email").setValue("some@cool.com");

        rock=findViewById(R.id.rock);
        paper=findViewById(R.id.paper);
        scissor=findViewById(R.id.scissor);
        textView=findViewById(R.id.textView);
        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameRef.setValue("Rock");
            }
        });
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameRef.setValue("Paper");
            }
        });
        scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameRef.setValue("Scissor");
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        gameRef.setValue("cool");
        gameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text1=dataSnapshot.getValue().toString();
                textView.setText(text1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
