package com.shop.controller;

import com.shop.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ChangePass", value = "/doChangePass")
public class ChangePassController  extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String oldPass = request.getParameter("oldpass");
        String newPass = request.getParameter("newpass");
        String rePass = request.getParameter("reenterpass");
        if(newPass.equals(rePass)){
            UserDao changepassword = new UserDao();
            try {
                boolean set = changepassword.changePass(userid, oldPass, newPass);
                if(set == true) {
                    request.setAttribute("MessagecPass", " Mật khẩu đã được thay đổi !!!");
                    RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
                    rd.forward(request, response);
                }
                else {
                    request.setAttribute("errMessagecPass", "Sai mật khẩu !!!");
                    RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
                    rd.forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("errMessage", "Mật khẩu không trùng khớp !!!");
            RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
            rd.forward(request, response);
        }

        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("profile.jsp");
        dispatcher.forward(request, response);
    }
}

