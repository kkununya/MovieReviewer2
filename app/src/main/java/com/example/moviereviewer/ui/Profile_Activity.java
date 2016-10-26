package com.example.moviereviewer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moviereviewer.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Profile_Activity extends AppCompatActivity implements View.OnClickListener {

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //defining a database reference
    private DatabaseReference databaseReference;

    //our new views
    private EditText editUserName, editFirstName, editLastName;
    private Button buttonSave, buttonback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();


        //if the user is not logged in
        //that means current user will return null
        if (firebaseAuth.getCurrentUser() == null) {
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, Login_Activity.class));
        }

        //getting the database reference
        databaseReference = FirebaseDatabase.getInstance().getReference();

        //getting the views from xml resource
        editUserName = (EditText) findViewById(R.id.username);
        editFirstName = (EditText) findViewById(R.id.fn);
        editLastName = (EditText) findViewById(R.id.ln);
        buttonSave = (Button) findViewById(R.id.save);
        buttonback = (Button) findViewById(R.id.back);

        buttonSave.setOnClickListener(this);
        buttonback.setOnClickListener(this);
    }


    private void saveUserInformation() {
        //Getting values from database
        String name = editUserName.getText().toString().trim();
        String first = editFirstName.getText().toString().trim();
        String last = editLastName.getText().toString().trim();

        //creating a userinformation object
        UserInformation userInformation = new UserInformation(name, first, last);

        //getting the current logged in user
        FirebaseUser user = firebaseAuth.getCurrentUser();


        databaseReference.child(user.getUid()).setValue(userInformation);

        //displaying a success toast
        Toast.makeText(this, "Information Saved...", Toast.LENGTH_LONG).show();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    @Override
    public void onClick(View view) {
        if(view == buttonSave){
            saveUserInformation();
        }
        if(view == buttonback){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

    }
}
