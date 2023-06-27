package com.shop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static DBConnect instance;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/shop";
    private static final String USER = "root";
    private static final String PASS = "";
    public DBConnect(){

    }
    public static DBConnect getInstance(){
        if(instance == null){
            instance = new DBConnect();
        }
        return instance;
    }
    public static Connection getConnect(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
