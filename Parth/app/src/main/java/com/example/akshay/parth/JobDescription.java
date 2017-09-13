package com.example.akshay.parth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class JobDescription extends AppCompatActivity {

    EditText mAddTitle;

    EditText mAddNumber;

    EditText mAddDescription;

    EditText mAddAddress;

    EditText mAddName;


    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mNotifyDatabaseReference;



    JobSeekerInfo object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_description);
        mAddTitle=(EditText)findViewById(R.id.Addtitle);
        mAddNumber=(EditText)findViewById(R.id.Addnumber);
        mAddDescription=(EditText)findViewById(R.id.Adddesc);
        mAddAddress=(EditText)findViewById(R.id.Addaddress);
        mAddName=(EditText)findViewById(R.id.Addname);


        mFirebaseDatabase=FirebaseDatabase.getInstance();

        mNotifyDatabaseReference=mFirebaseDatabase.getReference().child("JobSeekers");

    }

    public void EntrySubmitted(View view) {

        Log.i("message","Log message job description 3");
        object = new JobSeekerInfo(mAddTitle.getText().toString());
        object.setPhnNoUser(mAddNumber.getText().toString());
        object.setDescriptionUser(mAddDescription.getText().toString());
        object.setAddressUser(mAddAddress.getText().toString());
        object.setNameUser(mAddName.getText().toString());

        mNotifyDatabaseReference.push().setValue(object);
        Log.i("message","Log message job description 1");
        Intent i =new Intent(this,MainActivity.class);

        Log.i("message","Log message job description 2");
        startActivity(i);


    }
}
