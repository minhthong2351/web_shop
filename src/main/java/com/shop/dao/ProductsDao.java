package com.shop.dao;

import com.shop.beans.Products;

import com.shop.beans.User;
import com.shop.db.DBConnect;
import com.shop.db.JDBIConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shop.db.DBConnect;
import com.shop.db.JDBIConnector;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsDao {
    private static ProductsDao instance;

    Connection conn;
    PreparedStatement preparedStatement;
    private int noOfRecords;
    Statement stmt;
    PreparedStatement ps = null;
    ResultSet rs = null;
    PreparedStatement preparedStatement1;
    public ProductsDao(){}

    public static ProductsDao getInstance(){
        if(instance==null){
            instance = new ProductsDao();
        }
        return instance;
    }
    public List<Products> getAll(){
        return  JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select * from products").mapToBean(Products.class).stream().collect(Collectors.toList());
        });
    }
    public Products getById(String id) {
        return  JDBIConnector.get().withHandle(
                h -> h.createQuery("select * from products where id = ?").bind(0,id).mapToBean(Products.class).first());
        }
public Products getProductByID(String pid) {
    String query = "select * from products where id = ?";
    try {
        conn = new DBConnect().getConnect();
        ps = conn.prepareStatement(query);
        ps.setString(1, pid);
        rs = ps.executeQuery();
        while (rs.next()) {
            return new Products(rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getInt(6),
                    rs.getString(7),
                    rs.getInt(8));

        }

    } catch (Exception e) {
    }
    return null;
}



public void deleteProduct(String id){
    Connection conn =null;
    PreparedStatement ps= null;
    ResultSet rs=null;
    String query="delete from products\n"+ "where id=?";
    try {
        conn= new DBConnect().getConnect();
        ps= conn.prepareStatement(query);
        ps.setString(1, id);
        ps.executeUpdate();
    } catch (Exception e) {

    }

}
    // phuong thuc insert
    public void insertProduct(String id, String name, String description, String price, String sellPrice, String quantity, String img, String quantitySold){
        Connection conn =null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        String query = " insert into products values(?,?,?,?,?,?,?,?)";


        try {
            conn = new DBConnect().getConnect();
            ps=  conn.prepareStatement(query) ;
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, description);
            ps.setString(4, price);
            ps.setString(5, sellPrice);
            ps.setString(6, quantity);
            ps.setString(7, img);
            ps.setString(8, quantitySold);
            ps.executeUpdate();
        }catch (Exception e){
        }
    }
    // phuong thuc lay thong tin cua user tu id
    public Products getUserByID(String id) {
        Connection conn = null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        String query = "select * from products\n" + "where id=?";
        try {
            conn = new DBConnect().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Products(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8)
                       );

            }

        } catch (Exception e) {
        }
        return null;
    }

    public List<Products> viewAllProducts(int offset, int noOfRecords)
    {
        String query = "select SQL_CALC_FOUND_ROWS * from products limit " + offset + ", " + noOfRecords;
        List<Products> list = new ArrayList<>();
        Connection conn = DBConnect.getConnect();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Products products = new Products();
                products.setId(rs.getString("id"));
                products.setName(rs.getString("name"));
                products.setPrice(rs.getInt("price"));
                products.setImg(rs.getString("img"));
                products.setSellPrice(rs.getInt("sellPrice"));
                list.add(products);
            }

            rs.close();
            rs = stmt.executeQuery("SELECT FOUND_ROWS()");

            if (rs.next())
                this.noOfRecords = rs.getInt(1);
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally
        {
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    public int getNoOfRecords() { return noOfRecords; }
//    public void add(Products productModel) {
//        String sql = "INSERT INTO `product`(`catalog_id`, `name`, `price`, `qty`, `content`, `discount`, `image_link`) VALUES (?,?,?,?,?,?,?)";
//        update(sql, Products.getCatalog_id(), Products.getName(), Products.getPrice(), Products.getQty(), Products.getContent(), Products.getDiscount(), Products.getImage_link());
//    }


}
