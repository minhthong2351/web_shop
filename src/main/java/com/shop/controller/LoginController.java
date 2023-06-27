package com.shop.controller;

import com.shop.Util.SessionUtil;
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

@WebServlet(name = "Login", value = "/doLogin")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDao login = new UserDao();
        try {
            User user = login.checkLogin(username, password);
            if(user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("userid", user.getUserid());
                session.setAttribute("username", user.getUsername());
                session.setAttribute("password", AES256.decrypt(user.getPassword()));
                session.setAttribute("name", user.getName());
                session.setAttribute("phone", user.getPhone());
                session.setAttribute("email", user.getEmail());
                session.setAttribute("address", user.getAddress());
                session.setAttribute("isAdmin", user.isAdmin());
                if (user.isAdmin() != 0) {
                    SessionUtil.getInstance().putValue(request, "user", user);
                    response.sendRedirect(request.getContextPath() + "/Admin");
                } else {
                    SessionUtil.getInstance().putValue(request, "user", user);
                    response.sendRedirect(request.getContextPath() + "/Index");
                }
            }
            else {
                request.setAttribute("errorMsg", "Tài khoản đăng nhập hoặc mật khẩu sai hoặc tài khoản chưa được kích hoạt !!!");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
