package com.shop.controller.Cart;

import com.shop.beans.Cart;
import com.shop.beans.Products;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Delete", value = "/DeleteCart")
public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession();
        String id = request.getParameter("id");
        Cart cart =(Cart) session.getAttribute("cart");

        if(cart==null) {
            cart = Cart.getInstance();
        }
        Products remove=cart.remove(id);
        session.setAttribute("cart",cart);
        if(remove==null) response.setStatus(HttpServletResponse.SC_FOUND);
    }
}
