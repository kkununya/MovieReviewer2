package com.example.moviereviewer.model;

import java.io.Serializable;

/**
 * Created by Cereal on 10/27/2016.
 */

public class Movie implements Serializable {

    private String name;
    private String picture;
    private String prolog;
    private String trailer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getProlog() {
        return prolog;
    }

    public void setProlog(String prolog) {
        this.prolog = prolog;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
}
