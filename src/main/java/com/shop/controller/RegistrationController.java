package com.shop.controller;

import com.shop.beans.User;
import com.shop.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Register", value = "/doRegister")
public class RegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegistrationController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/register.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String name = request.getParameter("name");
        String address = request.getParameter("address");

        User user = new User(userid, username, password, name, phone, email, address);

        UserDao register = new UserDao();
        if(password.equals(repassword)){
            if (register.RegisterUser(user) == 1)
            {
                request.setAttribute("Message", "Bạn đã tạo tài khoàn thành công. Vui lòng truy cập vào đường link trong gmail của bạn để kích hoạt tài khoản !!!");
                RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
                rd.forward(request, response);
            } else if(register.RegisterUser(user) == 2) {
                request.setAttribute("errMessage", "Tài khoản đã tồn tại. Hãy thử lại !!!");
                RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
                rd.forward(request, response);
            }else if(register.RegisterUser(user) == 3) {
                request.setAttribute("errMessage", "Email đã được sử dụng. Hãy thử lại !!!");
                RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
                rd.forward(request, response);
            }
        } else {
            request.setAttribute("errMessage", "Mật khẩu không trùng khớp !!!");
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
        }

    }
}
