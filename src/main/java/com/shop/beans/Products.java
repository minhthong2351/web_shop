package com.shop.beans;

import java.io.Serializable;

public class Products implements Serializable {
    private  static final long seriaVersionUID= 1L;
    private String id;
    private String name;
    private String descripsion;
    private int price;
    private int sellPrice;
    private int quantity;
    private String img;

    private int quantitySold;

    public Products(){

    }

    public Products(String id, String name, String descripsion, int price, int sellPrice, int quantity, String img, int quantitySold) {
        this.id = id;
        this.name = name;
        this.descripsion = descripsion;
        this.price = price;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
        this.img = img;
        this.quantitySold=quantitySold;
    }

    public static void add(Products products) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripsion() {
        return descripsion;
    }

    public void setDescripsion(String descripsion) {
        this.descripsion = descripsion;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        if(quantitySold<=quantity && quantitySold>0) {
            this.quantitySold = quantitySold;
        }
    }

    public double getTotal() {

        return quantitySold*sellPrice;
    }

    public void delete(Products product) {
    }

    public Products findById(long parseLong) {
        return null;
    }

    public Object findAll() {
        return null;
    }

    public void setList(Object all) {
    }

    public void edit(Products productModel) {
    }
}
