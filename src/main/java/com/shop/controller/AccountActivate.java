package com.shop.controller;

import com.shop.db.DBConnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "AccountActivate", value = "/AccountActivate")

public class AccountActivate extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("key1");
        String password = request.getParameter("key2");
        Connection conn = DBConnect.getConnect();
        PreparedStatement preparedStatement;
        try {
            preparedStatement=conn.prepareStatement("SELECT email,password,status FROM user WHERE email=? AND password=? AND status='0'");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()){;
                preparedStatement=conn.prepareStatement("UPDATE user SET status='1' WHERE email=? AND password=?");
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                int i = preparedStatement.executeUpdate();
                if(i==1){
                    response.sendRedirect("/shop_war/active.jsp");
                }
                else{
                    response.sendRedirect("/shop_war/register.jsp");
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
