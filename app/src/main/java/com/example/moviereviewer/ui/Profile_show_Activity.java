package com.example.moviereviewer.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.moviereviewer.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile_show_Activity extends AppCompatActivity{

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    private Firebase ref;
    private Query qRef;
    private TextView textName, textFirst, textLast, textBirthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_show_page);

        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser userAuth = firebaseAuth.getCurrentUser();

        textName = (TextView) findViewById(R.id.name);
        textFirst = (TextView) findViewById(R.id.fn);
        textLast = (TextView) findViewById(R.id.ln);
        textBirthday = (TextView) findViewById(R.id.birthday);

        Firebase.setAndroidContext(this);
        ref = new Firebase("https://moviereviewer-34f20.firebaseio.com/User/"+userAuth.getUid()+"/name");

        qRef = ref.orderByChild("name");

        qRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("data : 555555555555555555555555555555555555 : " + dataSnapshot.getValue().toString());
                /*for (DataSnapshot msg : dataSnapshot.getChildren()) {

                    FirebaseUser userAuth = firebaseAuth.getCurrentUser();
                    // Retrieve all data from FireBase using QueryUtility
                    user userInfo = QueryUtility.extractUser(msg, userAuth.getUid());
                    setTextView(userInfo);

                }*/
                textName.setText(dataSnapshot.getValue().toString());



            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });





        //if the user is not logged in
        //that means current user will return null
        /*if (firebaseAuth.getCurrentUser() == null) {
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, Login_Activity.class));
        }*/


    }

    private void setTextView(user userInfo){
        textName.setText(userInfo.getName());
        textFirst.setText(userInfo.getFirst());
        textLast.setText(userInfo.getLast());
        textBirthday.setText(userInfo.getBirthday());
    }

    public void onStart(){
        super.onStart();
    }
}
