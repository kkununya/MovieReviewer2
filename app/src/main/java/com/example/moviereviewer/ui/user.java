package com.example.moviereviewer.ui;

/**
 * Created by Cereal on 10/24/2016.
 */

public class user {

    private String name;
    private String first;
    private String last;
    private String birthday;

    public user(){

    }

    public user(String name, String first, String last, String birthday) {
        this.setName(name);
        this.setFirst(first);
        this.setLast(last);
        this.setBirthday(birthday);
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

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
