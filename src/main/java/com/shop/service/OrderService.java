package com.shop.service;

import com.shop.beans.Cart;
import com.shop.beans.Order;
import com.shop.beans.Products;
import com.shop.beans.User;
import com.shop.dao.OrderDao;
import com.shop.db.JDBIConnector;
import org.jdbi.v3.core.result.ResultBearing;

public class OrderService {
    private static OrderService instance;
    private OrderService() {
    }
    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    public boolean createOrder(String userName, String cartTotal, String userId,String email,String phone, String address, Cart cart) {
        return OrderDao.getInstance().createOrder(userName,cartTotal,userId,email,phone,address, cart);
    }
}

