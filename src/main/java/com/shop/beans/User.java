package com.shop.beans;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionID = 1L;
    private String userid;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String address;
    private int isAdmin;
    public User(){

    }
    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }
    public User(String userid, String username, String password, String name, String phone, String email, String address) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;

    }
    public User(String userid, String username, String password, String name, String phone, String email, String address, int isAdmin) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.isAdmin = isAdmin;

    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int isAdmin() {
        return isAdmin;
    }

    public void setAdmin(int admin) {
        isAdmin = admin;
    }
}
