package com.example.myecomerce.models;

public class HomeCategory {

    String name;
    String img_url;
    String type;

    public HomeCategory() {
    }


    public HomeCategory(String name, String img_url, String type) {
        this.name = name;
        this.img_url = img_url;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public HomeCategory setName(String name) {
        this.name = name;
        return this;
    }

    public String getImg_url() {
        return img_url;
    }

    public HomeCategory setImg_url(String img_url) {
        this.img_url = img_url;
        return this;
    }

    public String getType() {
        return type;
    }

    public HomeCategory setType(String type) {
        this.type = type;
        return this;
    }
}
