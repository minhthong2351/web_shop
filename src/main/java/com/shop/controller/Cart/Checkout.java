package com.shop.controller.Cart;

import com.shop.beans.Cart;
import com.shop.beans.Order;
import com.shop.beans.User;
import com.shop.dao.OrderDao;
import com.shop.dao.UserDao;
import com.shop.service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Checkout", value = "/Checkout")
public class Checkout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        String cartTotal = request.getParameter("carttotal");
        String userName = request.getParameter("name");
        String userId = request.getParameter("userid");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        UserDao dao = new UserDao();
        try {
                OrderDao saveOrder = new OrderDao();
                if(saveOrder.createOrder(userName,cartTotal,userId, email,phone, address,cart)){
                    session.removeAttribute("cart");
                    request.setAttribute("Message", "Bạn đã đặt hàng thành công !!!");
                    RequestDispatcher rd = request.getRequestDispatcher("/thanh_toan.jsp");
                    rd.forward(request, response);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
