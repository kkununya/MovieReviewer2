package com.example.moviereviewer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.moviereviewer.R;
import com.example.moviereviewer.adapter.MovieAdapter;
import com.example.moviereviewer.model.Movie;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private RecyclerView recView;
    private MovieAdapter adapter;
    private Intent i;
    private List<Movie> movieList;
    private static String TAG = "MainActivity";


    //firebase auth object
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView img = (ImageView)findViewById(R.id.test);
        firebaseAuth = FirebaseAuth.getInstance();

        //if the objects getcurrentuser method is not null
        //means user is already logged in
        /*if(firebaseAuth.getCurrentUser() != null){
            //close this activity
            finish();
            //opening profile activity
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }*/

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        movieList = new ArrayList<>();
        recView = (RecyclerView)findViewById(R.id.rec_list);
        recView.setLayoutManager(new GridLayoutManager(this, 3));
        adapter = new MovieAdapter(movieList, this);

        recView.setAdapter(adapter);
        Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/moviereviewer-34f20.appspot.com/o/image%2Fdoctor_strange_cover.jpg?alt=media&token=8178412c-60d3-4a15-b716-c8580a5d8611").into(img);
        FirebaseDatabase.getInstance().getReference("movie-list").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot test: dataSnapshot.getChildren()){
                    Log.i(TAG, "movie data get");
                    Movie movie = test.getValue(Movie.class);
                    Log.i(TAG, movie.getPicture());
                    movieList.add(movie);
                    adapter.notifyItemInserted(movieList.size()-1);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, databaseError.getMessage());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.profile:
                finish();
                i = new Intent(getApplicationContext(), Profile_show_Activity.class);
                startActivity(i);
                return true;
            case R.id.logout:
                firebaseAuth.signOut();
                finish();
                i = new Intent(getApplicationContext(), Login_Activity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}