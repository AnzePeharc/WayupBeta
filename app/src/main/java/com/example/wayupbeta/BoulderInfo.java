package com.example.wayupbeta;

import android.media.Image;
import android.widget.ImageView;

public class BoulderInfo {

    // string variable for
    // storing boulder name, grade, image.
    private String boulderName, boulderGrade, boulderImage;

    // an empty constructor is
    // required when using
    // Firebase Realtime Database.
    public BoulderInfo() {

    }
    // constructor for our object class.
    public BoulderInfo(String name, String grade, String imgUrl) {
        this.boulderName = name;
        this.boulderGrade = grade;
        this.boulderImage = imgUrl;
    }

    // created getter and setter methods
    // for all our variables.
    public String getBoulderName() {
        return boulderName;
    }

    public void setBoulderName(String boulderName) {
        this.boulderName = boulderName;
    }

    public String getBoulderGrade() {
        return boulderGrade;
    }

    public void setBoulderGrade(String boulderGrade) {
        this.boulderGrade = boulderGrade;
    }

    public String getBoulderImageUrl() {
        return boulderImage;
    }

    public void setBoulderImage(String boulderImage) {
        this.boulderImage = boulderImage;
    }
}
