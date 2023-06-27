package com.shop.controller.admin;

import com.shop.beans.Products;
import com.shop.beans.User;
import com.shop.dao.UserDao;
import com.shop.service.ProductsService;
import com.shop.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AccountController", value = "/AccountAdmin")
public class AccountController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. get data from dao
        UserDao dao = new UserDao();
        List<User> list = dao.getAllUser();
        //2. set data from jsp
        request.setAttribute("listS", list);
        request.getRequestDispatcher("admin/accounts.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
