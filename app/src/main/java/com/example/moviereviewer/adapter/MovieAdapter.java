package com.example.moviereviewer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviereviewer.R;
import com.example.moviereviewer.model.Movie;

import java.util.List;

/**
 * Created by Cereal on 10/27/2016.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder>{

    private List<Movie> listData;
    private LayoutInflater inflater;
    private Context c;

    public MovieAdapter(List<Movie> listData, Context c){
        this.inflater = LayoutInflater.from(c);
        this.listData = listData;
        this.c = c;
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        Movie item = listData.get(position);
        holder.title.setText(item.getName());
        Glide.with(c).load(item.getPicture()).into(holder.icon);

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class MovieHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private ImageView icon;
        private View container;

        public MovieHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.textView);
            icon = (ImageButton)itemView.findViewById(R.id.imageView);
            container = itemView.findViewById(R.id.contain);
        }



    }
}