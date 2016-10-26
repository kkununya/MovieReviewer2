package com.example.moviereviewer.test;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
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

public class SignUpActivity extends AppCompatActivity{

    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignup, loginError;

    private ProgressDialog progressDialog;


    //defining firebaseauth object
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //initializing firebase auth object
        firebaseAuth = ((FirebaseApplication)getApplication()).getFirebaseAuth();

        //if getCurrentUser does not returns null
        /*if(firebaseAuth.getCurrentUser() != null){
            //that means user is already logged in
            //so close this activity
            finish();

            //and open profile activity
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }*/

        //initializing views
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.psw1);
        textViewSignup = (TextView) findViewById(R.id.textViewSignUp);
        loginError = (TextView) findViewById(R.id.login_error);
        textViewSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent = new Intent(SignUpActivity.this, testActivity.class);
                startActivity(signUpIntent);
            }
        });
        final Button loginButton = (Button)findViewById(R.id.loginBut);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredEmail = editTextEmail.getText().toString();
                String enteredPassword = editTextPassword.getText().toString();
                if(TextUtils.isEmpty(enteredEmail) || TextUtils.isEmpty(enteredPassword)){
                    Helper.displayMessageToast(SignUpActivity.this, "Login fields must be filled");
                    return;
                }
                if(!Helper.isValidEmail(enteredEmail)){
                    Helper.displayMessageToast(SignUpActivity.this, "Invalidate email entered");
                    return;
                }
                ((FirebaseApplication)getApplication()).createNewUser(SignUpActivity.this, enteredEmail, enteredPassword, loginError);
            }
        });
    }
}