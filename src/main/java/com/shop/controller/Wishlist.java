package com.shop.controller;

import com.shop.beans.Products;
import com.shop.service.ProductsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Wishlist", value = "/wishlist")
public class Wishlist extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Products> products= ProductsService.getInstance().getAll();
        request.setAttribute("products",products);
        request.getRequestDispatcher("wishlist.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
