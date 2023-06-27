package com.shop.controller.admin;

import com.shop.dao.ProductsDao;
import com.shop.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddProduct", value = "/AddProduct")
public class AddProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sid = request.getParameter("id");
        String sname = request.getParameter("name");
        String sdescription = request.getParameter("description");
        String sprice = request.getParameter("price");
        String ssellPrice = request.getParameter("sellPrice");
        String squantity = request.getParameter("quantity");
        String simg = request.getParameter("img");
        String squantitySold = request.getParameter("quantitySold");

        ProductsDao dao = new ProductsDao();
        dao.insertProduct(sid,sname,sdescription,sprice,ssellPrice,squantity,simg,squantitySold);
        response.sendRedirect("admin-products");

    }
}
