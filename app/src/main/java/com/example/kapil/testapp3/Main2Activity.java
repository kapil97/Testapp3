package com.example.kapil.testapp3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {
    private Button mLogOutBtn;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mAuth=FirebaseAuth.getInstance();
        mLogOutBtn=(Button)findViewById(R.id.button3);
    mAuthListener=new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
         if(firebaseAuth.getCurrentUser()==null){
             startActivity(new Intent(Main2Activity.this,MainActivity.class));
         }
        }
    };

        mLogOutBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mAuth.signOut();
        }
    });
    }

    @Override
    protected void onStart() {
        super.onStart();
    mAuth.addAuthStateListener(mAuthListener);
    }
}

