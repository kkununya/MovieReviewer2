package com.example.moviereviewer.test;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.moviereviewer.Helper.Helper;
import com.example.moviereviewer.R;
import com.google.firebase.auth.FirebaseAuth;

public class testActivity extends AppCompatActivity{
    private static final String TAG = testActivity.class.getSimpleName();

    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignup, loginError;

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //progress dialog
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //getting firebase auth object
        firebaseAuth = ((FirebaseApplication) getApplication()).getFirebaseAuth();
        ((FirebaseApplication)getApplication()).checkUserLogin(testActivity.this);
        //if the objects getcurrentuser method is not null
        //means user is already logged in
        /*if(firebaseAuth.getCurrentUser() != null){
            //close this activity
            finish();
            //opening profile activity
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }*/

        //initializing views
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.psw1);
        textViewSignup = (TextView) findViewById(R.id.textViewSignUp);
        loginError = (TextView) findViewById(R.id.login_error);

        progressDialog = new ProgressDialog(this);

        //attaching click listener
        textViewSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent = new Intent(testActivity.this, SignUpActivity.class);
                startActivity(signUpIntent);
            }
        });
        final Button buttonLogIn = (Button) findViewById(R.id.loginBut);
        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredEmail = editTextEmail.getText().toString();
                String enteredPassword = editTextPassword.getText().toString();
                progressDialog.setMessage("Please Wait...");
                progressDialog.show();
                if (TextUtils.isEmpty(enteredEmail) || TextUtils.isEmpty(enteredPassword)) {
                    Helper.displayMessageToast(testActivity.this, "Login fields must be filled");
                    return;
                }
                if (!Helper.isValidEmail(enteredEmail)) {
                    Helper.displayMessageToast(testActivity.this, "Invalidate email entered");
                    return;
                }
                ((FirebaseApplication) getApplication()).loginAUser(testActivity.this, enteredEmail, enteredPassword, loginError);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        //mAuth.addAuthStateListener(((FirebaseApplication)getApplication()).mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (((FirebaseApplication) getApplication()).mAuthListener != null) {
            //mAuth.removeAuthStateListener(((FirebaseApplication)getApplication()).mAuthListener);
        }
    }
}