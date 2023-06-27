package com.shop.controller.Cart;

import com.shop.beans.Cart;
import com.shop.beans.Products;
import com.shop.service.ProductsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Add", value = "/AddCart")
public class Add extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        HttpSession session= request.getSession();
        Cart cart =(Cart) session.getAttribute("cart");
        if(cart == null){
            cart= Cart.getInstance();
        }
        Products p= ProductsService.getInstance().getById(id);
        cart.put(p);
        session.setAttribute("cart",cart);
        response.sendRedirect("/shop_war/cart");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
