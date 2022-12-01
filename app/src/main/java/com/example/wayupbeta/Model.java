package com.example.wayupbeta;

public class Model {

    private String imageUrl, boulderName, boulderGrade;

    public Model(){

    }

    public Model(String imageUrl, String boulderName, String boulderGrade){
        this.imageUrl = imageUrl;
        this.boulderName = boulderName;
        this.boulderGrade = boulderGrade;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

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

}
