package com.developer.solutions.recyclerviewwithmultipleviewtype.model;

import java.util.ArrayList;


public class MyModel {

    private int id;
    private String title;
    private ArrayList<String> sliderImages;

    public MyModel(int id, String title, ArrayList<String> sliderImages) {
        this.id = id;
        this.title = title;
        this.sliderImages = sliderImages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getSliderImages() {
        return sliderImages;
    }

    public void setSliderImages(ArrayList<String> sliderImages) {
        this.sliderImages = sliderImages;
    }


}
