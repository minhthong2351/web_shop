package com.shop.controller.admin;

import com.shop.dao.ProductsDao;
import com.shop.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteProductController", value = "/DeleteProductController")
public class DeleteProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// get sid from jsp
        String id= request.getParameter("sid");
        // bb2 pass sid to dao
        ProductsDao dao = new ProductsDao();
        dao.deleteProduct(id);
        // day ve trang home
        response.sendRedirect("admin-products");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
