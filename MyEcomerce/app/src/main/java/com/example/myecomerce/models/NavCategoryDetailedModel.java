package com.example.myecomerce.models;

public class NavCategoryDetailedModel {
    String name;
    String type;
    String img_url;
    String price;

    public NavCategoryDetailedModel() {
    }

    public NavCategoryDetailedModel(String name, String type, String img_url, String price) {
        this.name = name;
        this.type = type;
        this.img_url = img_url;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public NavCategoryDetailedModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public NavCategoryDetailedModel setType(String type) {
        this.type = type;
        return this;
    }

    public String getImg_url() {
        return img_url;
    }

    public NavCategoryDetailedModel setImg_url(String img_url) {
        this.img_url = img_url;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public NavCategoryDetailedModel setPrice(String price) {
        this.price = price;
        return this;
    }
}
