package com.example.myecomerce.models;

import java.io.Serializable;

public class ViewAllModel implements Serializable {
    String name;
    String description;
    String rating;
    String img_url;
    String type;
    int price;

    public ViewAllModel() {
    }

    public ViewAllModel(String name, String description, String rating, String img_url, String type, int price) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.img_url = img_url;
        this.type = type;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public ViewAllModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ViewAllModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getRating() {
        return rating;
    }

    public ViewAllModel setRating(String rating) {
        this.rating = rating;
        return this;
    }

    public String getImg_url() {
        return img_url;
    }

    public ViewAllModel setImg_url(String img_url) {
        this.img_url = img_url;
        return this;
    }

    public String getType() {
        return type;
    }

    public ViewAllModel setType(String type) {
        this.type = type;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public ViewAllModel setPrice(int price) {
        this.price = price;
        return this;
    }
}
