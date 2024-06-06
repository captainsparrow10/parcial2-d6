package com.example.tiendafake.models;

public class Product {
    int image, id;
    String title, price;

    public Product(int image, int id, String title, String price) {
        this.image = image;
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
