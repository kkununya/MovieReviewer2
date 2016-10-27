package com.example.moviereviewer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainTestActivity extends AppCompatActivity {

    public static class RoomViewHolder extends RecyclerView.ViewHolder{
        public TextView textName, textFirst, textLast;

        public RoomViewHolder(View v){
            super(v);
            textName = (TextView)itemView.findViewById(R.id.name);
            textFirst = (TextView)itemView.findViewById(R.id.first);
            textLast = (TextView)itemView.findViewById(R.id.last);

        }
    }

    public static final String USER = "User";

    private static final String TAG = "MainTestActivity";

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;

    private DatabaseReference mFirebaseData;
    private FirebaseRecyclerAdapter<userTest, RoomViewHolder> mFirebaseAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);

        mRecyclerView = (RecyclerView)findViewById(R.id.roomRecyclerView);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setStackFromEnd(true);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mFirebaseData = FirebaseDatabase.getInstance().getReference();
        mFirebaseAdapter = new FirebaseRecyclerAdapter<userTest, RoomViewHolder>(
                userTest.class,
                R.layout.test,
                RoomViewHolder.class,
                mFirebaseData.child(USER)
        ) {
            @Override
            protected void populateViewHolder(RoomViewHolder viewHolder, userTest model, int position) {
                viewHolder.textName.setText(model.getName());
                viewHolder.textFirst.setText(model.getFirst());
                viewHolder.textLast.setText(model.getLast());

            }
        };

        mFirebaseAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver(){
            public void onItemRangeInserted(int positionStart, int itemCount){
                super.onItemRangeInserted(positionStart, itemCount);
                int Count = mFirebaseAdapter.getItemCount();
                int lastVisiblePosition = mLinearLayoutManager.findLastCompletelyVisibleItemPosition();
                if(lastVisiblePosition == -1 || (positionStart >= (Count - 1) && lastVisiblePosition == (positionStart - 1))){
                    mRecyclerView.scrollToPosition(positionStart);
                }
            }
        });
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    public void onStart(){
        super.onStart();
    }
}
