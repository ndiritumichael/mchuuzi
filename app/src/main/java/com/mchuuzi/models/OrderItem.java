package com.mchuuzi.models;

import androidx.annotation.Nullable;

public class OrderItem {






    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    private int quantity;
    private String name;
    private int image;
    private Double price;



    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        final OrderItem orderItem = (OrderItem) obj;
        if (orderItem.name==null){
            return  false;
        }

        return orderItem.name.equals(this.name);


    }

    @Override
    public String toString() {

        return name+" "+price+" "+quantity;
    }

}
