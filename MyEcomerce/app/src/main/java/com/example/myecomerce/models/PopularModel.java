package com.example.myecomerce.models;

public class PopularModel {
    String name;
    String description;
    String rating;
    String discount;
    String type;
    String img_url;

    public PopularModel() {
    }

    public PopularModel(String name, String description, String rating, String discount, String type, String img_url) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.discount = discount;
        this.type = type;
        this.img_url = img_url;
    }


    public String getName() {
        return name;
    }

    public PopularModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PopularModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getRating() {
        return rating;
    }

    public PopularModel setRating(String rating) {
        this.rating = rating;
        return this;
    }

    public String getDiscount() {
        return discount;
    }

    public PopularModel setDiscount(String discount) {
        this.discount = discount;
        return this;
    }

    public String getType() {
        return type;
    }

    public PopularModel setType(String type) {
        this.type = type;
        return this;
    }

    public String getImg_url() {
        return img_url;
    }

    public PopularModel setImg_url(String img_url) {
        this.img_url = img_url;
        return this;
    }
}
