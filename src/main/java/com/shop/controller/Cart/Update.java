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

@WebServlet(name = "Update", value = "/UpdateCart")
public class Update extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession();
        String id = request.getParameter("id");
        String quantity= request.getParameter("quantity");
        Cart cart =(Cart) session.getAttribute("cart");

        if(cart==null) {
            cart = Cart.getInstance();
        }
        Products p=cart.get(id);
        session.setAttribute("cart",cart);
        if(p==null){
            response.setStatus(HttpServletResponse.SC_FOUND);
            return;

        }
        p.setQuantitySold((Integer.parseInt(quantity)));
        if(p.getQuantitySold()!=Integer.parseInt(quantity)) response.setStatus(405);
    }
}
