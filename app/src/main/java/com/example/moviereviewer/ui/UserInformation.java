package com.example.moviereviewer.ui;

/**
 * Created by Cereal on 10/24/2016.
 */

public class UserInformation {

    private String uId;
    private String email;
    private String name;
    private String first;
    private String last;
    private String birthday;

    public UserInformation(){

    }

    public UserInformation(String name, String first, String last, String birthday) {
        this.setuId(getuId());
        this.setEmail(getEmail());
        this.setName(name);
        this.setFirst(first);
        this.setLast(last);
        this.setBirthday(birthday);
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String date) { this.birthday = date; }
}
