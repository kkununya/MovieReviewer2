package com.example.moviereviewer.model;

import com.example.moviereviewer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kununya1996 on 10/14/2016.
 */

public class ListData {

    private static final String[] titles = {"Deep Water Horizon", "Ghostbusters", "Now You See Me 2",
            "Pete's Dragon", "Fanday แฟนกันแค่วันเดียว", "Train to Busan", "Suicide Squad", "Me before You",
            "Light out", "Storks"};
    private static final int[] icons = {R.drawable.deep_water_horizon, R.drawable.ghostbusters, R.drawable.now_you_see_me_2
            , R.drawable.petes_dragon, R.drawable.fanday, R.drawable.train_to_busan, R.drawable.suicide_squad,
            R.drawable.me_before_you, R.drawable.light_out};

    public static List<ListItem> getListData(){
        List<ListItem> data = new ArrayList<>();

        for(int x = 0; x < 1; x++){
            for(int i = 0; i < titles.length && i < icons.length; i++){
                ListItem item = new ListItem();
                item.setImageResId(icons[i]);
                item.setTitle(titles[i]);
                data.add(item);
            }
        }
        return data;
    }

}
