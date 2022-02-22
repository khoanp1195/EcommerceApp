package com.example.myecomerce.models;

public class NavCategoryModel {

    String name;
    String description;
    String discount;
    String img_url;
    String type;


    public NavCategoryModel() {
    }

    public NavCategoryModel(String name, String description, String discount, String img_url, String type) {
        this.name = name;
        this.description = description;
        this.discount = discount;
        this.img_url = img_url;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public NavCategoryModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public NavCategoryModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDiscount() {
        return discount;
    }

    public NavCategoryModel setDiscount(String discount) {
        this.discount = discount;
        return this;
    }

    public String getImg_url() {
        return img_url;
    }

    public NavCategoryModel setImg_url(String img_url) {
        this.img_url = img_url;
        return this;
    }

    public String getType() {
        return type;
    }

    public NavCategoryModel setType(String type) {
        this.type = type;
        return this;
    }
}
