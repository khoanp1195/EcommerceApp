package com.example.myecomerce.models;

public class RecommendedModel {

    String name;
    String description;
    String rating;
    String img_url;
    int price;

    public RecommendedModel() {
    }

    public RecommendedModel(String name, String description, String rating, String img_url, int price) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.img_url = img_url;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public RecommendedModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RecommendedModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getRating() {
        return rating;
    }

    public RecommendedModel setRating(String rating) {
        this.rating = rating;
        return this;
    }

    public String getImg_url() {
        return img_url;
    }

    public RecommendedModel setImg_url(String img_url) {
        this.img_url = img_url;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public RecommendedModel setPrice(int price) {
        this.price = price;
        return this;
    }
}
