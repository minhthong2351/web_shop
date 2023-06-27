package com.shop.beans;

import java.util.Date;
import java.util.List;

public class Order {

    private String order_id;
    private String user_id;
    private String status;
    private String full_name;
    private String address;
    private String phone_number;
    public Order(String order_id, String user_id, String status, String full_name, String address, String phone_number) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.status = status;
        this.full_name = full_name;
        this.address = address;
        this.phone_number = phone_number;

    }

    public Order() {

    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
