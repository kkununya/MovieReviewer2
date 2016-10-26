package com.example.moviereviewer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.moviereviewer.R;
import com.example.moviereviewer.adapter.ListAdapter;
import com.example.moviereviewer.model.ListData;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity{

    private RecyclerView recView;
    private ListAdapter adapter;
    private Intent i;

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        recView = (RecyclerView)findViewById(R.id.rec_list);
        recView.setLayoutManager(new GridLayoutManager(this, 3));

        adapter = new ListAdapter(ListData.getListData(), this);
        recView.setAdapter(adapter);

        ImageView img = (ImageView)findViewById(R.id.test);
        Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/moviereviewer-34f20.appspot.com/o/image%2Fsuicide_squad_cover.jpg?alt=media&token=b8c806b4-fc56-4050-a13c-505a63c46985").into(img);
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
                startActivity(new Intent(this, Login_Activity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}