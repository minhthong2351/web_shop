package com.shop.controller;

import com.shop.beans.User;
import com.shop.dao.UserDao;
import com.shop.service.AES256;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ViewProfile", value = "/doViewProfile")
public class ViewProfile extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        UserDao view = new UserDao();
        try {
            User user = view.viewProfile(userid);
            if(user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("userid", user.getUserid());
                session.setAttribute("username", user.getUsername());
                session.setAttribute("name", user.getName());
                session.setAttribute("phone", user.getPhone());
                session.setAttribute("email", user.getEmail());
                session.setAttribute("address", user.getAddress());
                RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
                rd.forward(request, response);
            }
            else {
                RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("profile.jsp");
        dispatcher.forward(request, response);
    }
}
