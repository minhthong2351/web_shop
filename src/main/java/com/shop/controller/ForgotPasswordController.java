package com.shop.controller;

import com.shop.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ForgotPassword", value = "/doForgot")
public class ForgotPasswordController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        UserDao fgpassword = new UserDao();
        try {
            boolean set = fgpassword.checkUser(username, email);
            if(set == true) {
                request.setAttribute("Message", " Mật khẩu đã được gửi vào email của bạn. Vui lòng truy cập email để lấy lại mật khẩu !!!");
                RequestDispatcher rd = request.getRequestDispatcher("forgotpassword.jsp");
                rd.forward(request, response);
            }
            else {
                request.setAttribute("errMessage", "Tài khoản đăng nhập hoặc email không tồn tại !!!");
                RequestDispatcher rd = request.getRequestDispatcher("forgotpassword.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
