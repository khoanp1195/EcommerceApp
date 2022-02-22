package com.example.myecomerce.models;

import java.io.Serializable;

public class MyCartModel implements Serializable {

    String productName;
    String productPrice;
    String currentTime;
    String currentDate;
    String totalQuantity;
    int totalPrice;
    String documentId;


    public MyCartModel() {

    }

    public MyCartModel(String productName, String productPrice, String currentTime, String currentDate, String totalQuantity, int totalPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.currentTime = currentTime;
        this.currentDate = currentDate;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
    }

    public String getDocumentId() {
        return documentId;
    }

    public MyCartModel setDocumentId(String documentId) {
        this.documentId = documentId;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public MyCartModel setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public MyCartModel setProductPrice(String productPrice) {
        this.productPrice = productPrice;
        return this;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public MyCartModel setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
        return this;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public MyCartModel setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
        return this;
    }

    public String getTotalQuantity() {
        return totalQuantity;
    }

    public MyCartModel setTotalQuantity(String totalQuantity) {
        this.totalQuantity = totalQuantity;
        return this;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public MyCartModel setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }
}
