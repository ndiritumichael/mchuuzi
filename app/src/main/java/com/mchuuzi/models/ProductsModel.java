package com.mchuuzi.models;

import java.io.Serializable;

public class ProductsModel implements Serializable {
    private String name;
    private Double price;
    private int image;

    private String description;


    public ProductsModel() {
    }

    public ProductsModel(String name, Double price, int image, String description) {
        this.name = name;
        this.price = price;
        this.image = image;

        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
