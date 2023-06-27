package com.shop.service;

import com.shop.beans.User;
import com.shop.dao.UserDao;

public class UserService {
    private static UserService instance;
    private UserService(){

    }
    public static UserService getInstance(){
        if(instance == null){
            instance = new UserService();
        }
        return instance;
    }
}
