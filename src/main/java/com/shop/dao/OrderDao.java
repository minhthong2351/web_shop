package com.shop.dao;

import com.shop.beans.Cart;
import com.shop.beans.Order;
import com.shop.beans.Products;
import com.shop.beans.User;
import com.shop.db.DBConnect;
import com.shop.db.JDBIConnector;
import com.shop.service.OrderService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Random;

public class OrderDao {
    private static OrderDao instance;
    Connection conn;
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    ResultSet rs = null;
    PreparedStatement preparedStatement;
    PreparedStatement preparedStatement1;

    public OrderDao() {
    }

    public static OrderDao getInstance() {
        if (instance == null) {
            instance = new OrderDao();
        }
        return instance;
    }

    public boolean createOrder(String userName, String cartTotal, String userId,String email,String phone, String address, Cart cart) {
        Map<String,Products> productsOrder = cart.getProductsMap();
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        String nowdate = date + "";
        Random random = new Random();
        int n = random.nextInt(99999999) + 11111111;
        String orderId = "" + n;
        int n1 = random.nextInt(99999999) + 11111111;
        String Id = "" + n1;
        boolean set = false;
        try {
            conn = DBConnect.getConnect();

            ps = conn.prepareStatement("insert into orders values(?,?,?,?,?,?,?,?)");
            ps.setString(1, orderId);
            ps.setString(2, userId);
            ps.setString(3, "");
            ps.setString(4, userName);
            ps.setString(5, address);
            ps.setString(6, phone);
            ps.setString(7, email);
            ps.setString(8, cartTotal);
            int rs1 =  ps.executeUpdate();
            if (rs1 > 0 ) {
                int rs2 = 0;
                for(Products p: productsOrder.values()){
                    ps = conn.prepareStatement("insert into order_details values(?,?,?,?,?,?,?,?)");
                ps.setString(1, Id);
                ps.setString(2, orderId);
                    ps.setString(3, p.getId());
                    ps.setString(4, p.getSellPrice()+"");
                    ps.setInt(5,p.getQuantitySold());
                ps.setString(6, "");
                ps.setString(7, nowdate);
                ps.setString(8, "");
                    rs2 =  ps.executeUpdate();
                }

                if(rs2 >0){
                    return set = true;
                }
            }
        } catch (Exception e) {

        }

        return set;
    }
}
