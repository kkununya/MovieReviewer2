package com.example.moviereviewer.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviereviewer.R;
import com.example.moviereviewer.model.ListData;
import com.example.moviereviewer.model.ListItem;

import java.util.List;

/**
 * Created by kununya1996 on 10/14/2016.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {

    private List<ListItem> listData;
    private LayoutInflater inflater;

    public ListAdapter(List<ListItem> listData, Context c){
        this.inflater = LayoutInflater.from(c);
        this.listData = listData;
    }


    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        ListItem item = listData.get(position);
        holder.title.setText(item.getTitle());
        holder.icon.setImageResource(item.getImageResId());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ListHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private ImageView icon;
        private View container;

        public ListHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.textView);
            icon = (ImageView)itemView.findViewById(R.id.imageView);
            container = itemView.findViewById(R.id.contain);
        }
    }

}
