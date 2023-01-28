package com.example.hostelappnitj;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.hostelappnitj.ModelResponse.User;
import com.example.hostelappnitj.ModelResponse.hostel;

public class SharedPrefManager {
    private static String SHARED_PREF_NAME = "Hostel_management";  //the corresponding to the shared preference
    private SharedPreferences sharedPreferences;
    Context context;
    private SharedPreferences.Editor editor ;

    public SharedPrefManager(Context context){   //the constructor to get the context of the application
        this.context=context;
    }

    public void SaveUser(User user){
//        this method will save all the values corressponding to the keys
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        editor.putString("_id", user.get_id());
        editor.putString("username", user.getUsername());
        editor.putString("avatar", user.getAvatar());
        editor.putString("email", user.getEmail());
        editor.putString("rollNumber",user.getRollNumber());
        editor.putString("branch", user.getBranch());
        editor.putString("address", user.getAddress());
        editor.putString("phone", user.getPhone());
        editor.putBoolean("logged",true);   //to check wheater the user is logged in or not
        editor.apply();
    }

    public boolean isloggedIn() {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("logged",false);
//if the user is logged in then the shared preference will contain the logged key with true valu
// else the false default value will be returned
    }

    public User getUser(){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(sharedPreferences.getString("_id","-1"),
                sharedPreferences.getString("username",null),
                sharedPreferences.getString("avatar",null),
                sharedPreferences.getString("email",null),
                sharedPreferences.getString("rollNumber",null),
                sharedPreferences.getString("branch",null),
                sharedPreferences.getString("address",null),
                sharedPreferences.getString("phone",null)
                );

    }

    public void logout(){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

//    shared preference for hostel
public void SaveHostelUser(hostel hostel){
//        this method will save all the values corressponding to the keys
    sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
    editor=sharedPreferences.edit();
    editor.putString("_id", hostel.get_id());
    editor.putString("roomNumber", hostel.getRoomNumber());
    editor.putString("hostelName", hostel.getHostelName());
    editor.putString("username", hostel.getUsername1());
    editor.putString("email", hostel.getEmail1());
    editor.putString("rollNumber",hostel.getRollNumber1());
    editor.putString("phone", hostel.getPhone1());
    editor.putString("fatherName", hostel.getFatherName1());
    editor.putString("fatherPhone", hostel.getFatherPhone1());
    editor.putString("address", hostel.getAddress1());
    editor.putString("branch", hostel.getBranch1());
    editor.apply();
}
    public hostel getHostelUser(){
//        the constructor should match with the constructor present in Hostel class
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new hostel(
                sharedPreferences.getString("_id","-1"),
                sharedPreferences.getString("roomNumber",null),
                sharedPreferences.getString("hostelName",null),
                sharedPreferences.getString("username",null),
                sharedPreferences.getString("email",null),
                sharedPreferences.getString("rollNumber",null),
                sharedPreferences.getString("phone",null),
                sharedPreferences.getString("fatherName",null),
                sharedPreferences.getString("fatherPhone",null),
                sharedPreferences.getString("address",null),
                sharedPreferences.getString("branch",null)
        );
    }


}
