package com.example.moviereviewer.Helper;

import android.content.Context;
import android.widget.Toast;

public class Helper {

    public static final String NAME = "name";

    public static final String EMAIL = "email";

    public static final String FIRST = "first";

    public static final String LAST = "last";

    public static final String BIRTHDAY = "birthday";

    public static boolean isValidEmail(String email){
        if(email.contains("@")){
            return true;
        }
        return false;
    }

    public static void displayMessageToast(Context context, String displayMessage){
        Toast.makeText(context, displayMessage, Toast.LENGTH_LONG).show();
    }
}
