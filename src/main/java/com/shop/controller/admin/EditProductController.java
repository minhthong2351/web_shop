package com.shop.controller.admin;


import com.shop.beans.Products;
import com.shop.beans.User;
import com.shop.dao.ProductsDao;
import com.shop.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(name = "EditProductController", value = "/edit-product")
public class EditProductController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id= request.getParameter("sid");
        ProductsDao dao= new ProductsDao();
        Products p= dao.getUserByID(id);

        request.setAttribute("st", p);
        request.getRequestDispatcher("admin/edit-product.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
