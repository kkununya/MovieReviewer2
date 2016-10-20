package com.example.moviereviewer.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.moviereviewer.R;

/**
 * Created by kununya1996 on 10/19/2016.
 */

public class Register_main_Activity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main);

        Button nextButton = (Button)findViewById(R.id.next_regis);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Register_Activity.class);
                startActivity(i);
            }
        });
    }



}
