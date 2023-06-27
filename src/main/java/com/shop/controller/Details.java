package com.shop.controller;

import com.shop.beans.Products;
import com.shop.dao.ProductsDao;
import com.shop.service.ProductsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Details", value = "/Details")
public class Details extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter("id");
        HttpSession session= request.getSession();
        ProductsDao p=new ProductsDao();
        p.getProductByID(id);
        session.setAttribute("product",p);
        request.getRequestDispatcher("productDetail.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
