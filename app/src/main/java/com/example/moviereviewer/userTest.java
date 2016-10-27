package com.example.moviereviewer;

/**
 * Created by Cereal on 10/27/2016.
 */

public class userTest {

    private String name;
    private String first;
    private String last;

    public userTest(){

    }

    public userTest(String name, String first, String last) {
        this.setName(name);
        this.setFirst(first);
        this.setLast(last);
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
}