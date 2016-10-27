package com.example.moviereviewer.Firebase;

import com.example.moviereviewer.ui.UserInformation;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
public class FirebaseDatabaseHelper {
    private static final String TAG = FirebaseDatabaseHelper.class.getSimpleName();
    private DatabaseReference databaseReference;
    public FirebaseDatabaseHelper(){
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }
    public void createUserInFirebaseDatabase(String userId, UserInformation userInfo){
        Map<String, UserInformation> user = new HashMap<String, UserInformation>();
        user.put(userId, userInfo);
        databaseReference.child("users").setValue(user);
    }
    /*private List<UserProfile> adapterSourceData(DataSnapshot dataSnapshot, String uId){
        List<UserProfile> allUserData = new ArrayList<UserProfile>();
        if(dataSnapshot.getKey().equals(uId)){
            UserInformation userInformation = dataSnapshot.getValue(UserInformation.class);
            allUserData.add(new UserProfile(Helper.NAME, userInformation.getName()));
            allUserData.add(new UserProfile(Helper.EMAIL, userInformation.getEmail()));
            allUserData.add(new UserProfile(Helper.FIRST, userInformation.getFirst()));
            allUserData.add(new UserProfile(Helper.LAST, userInformation.getLast()));
            allUserData.add(new UserProfile(Helper.BIRTHDAY, userInformation.getBirthday()));
            allUserData.

        }
        return allUserData;
    }*/
}
