package com.shop.controller;

import com.shop.beans.Products;
import com.shop.dao.ProductsDao;
import com.shop.service.ProductsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductsListController", value = "/store")
public class ProductsListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 9;
        if (request.getParameter("page") != null)
            page = Integer.parseInt(
                    request.getParameter("page"));
        ProductsDao dao = new ProductsDao();
        List<Products> list = dao.viewAllProducts(
                (page - 1) * recordsPerPage,
                recordsPerPage);
        int noOfRecords = dao.getNoOfRecords();
        int noOfPages = (int)Math.ceil(noOfRecords * 1.0
                / recordsPerPage);
        request.setAttribute("productList", list);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        RequestDispatcher view
                = request.getRequestDispatcher("store.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
