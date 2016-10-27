package com.example.moviereviewer.Util;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.moviereviewer.ui.user;
import com.firebase.client.DataSnapshot;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by 'Chayut' on 24/10/2559.
 * Helper methods related to requesting and receiving event data from FireBase.
 */

public final class QueryUtility {

    private static final String LOG_TAG = QueryUtility.class.getSimpleName();

    /**
     * Create a private constructor because no one should ever create a {@link QueryUtility} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name QueryUtility (and an object instance of QueryUtility is not needed).
     */
    private QueryUtility() {

    }


    public static user extractUser(DataSnapshot msg, String Uid){

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        // get properties Object here return in Map type and phase to JSON object below
        JSONObject UidObj = new JSONObject((Map) msg.getValue());

        String name = null, first = null, last = null, birthday = null;
        try {
            name = UidObj.getString("name");
            first = UidObj.getString("first");
            last = UidObj.getString("last");
            birthday = UidObj.getString("birthday");
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.toString());
        }

        user user2 = new user(name, first, last, birthday);

        return user2;

    }

    @SuppressLint("SimpleDateFormat")
    static private String dateFormat(String universalDate) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = format.parse(universalDate);
        return new SimpleDateFormat("dd MMMM yyyy").format(date);
    }



    static private JSONArray supportQuery(DataSnapshot msg){

        // get properties Object here return in Map type and phase to JSON object below
        //JSONArray tmpPropertiea = new JSONObject(msg.child("properties").child("events").getValue());
        //Log.v(LOG_TAG, "-->" + msg.child("properties").child("events").getValue());

        //GenericTypeIndicator<List<String>> t = new GenericTypeIndicator<List<String>>() {};


        JSONArray tmpEventsList = new JSONArray();
        List list = msg.child("properties").child("events").getValue(List.class);
        for (int i = 0; i < list.size(); i++) {
            tmpEventsList.put(list.get(i));
        }

        Log.v(LOG_TAG, list.size() + " : " + tmpEventsList.toString());

        return tmpEventsList;

    }


}
