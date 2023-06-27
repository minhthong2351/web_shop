package com.shop.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Logout", value = "/doLogout")
public class LogoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("userid");
            session.removeAttribute("username");
            session.removeAttribute("name");
            session.removeAttribute("phone");
            session.removeAttribute("email");
            session.removeAttribute("address");
            session.removeAttribute("address");
            session.removeAttribute("isAdmin");
        }
        response.sendRedirect(request.getContextPath() + "/Index");
    }

}
