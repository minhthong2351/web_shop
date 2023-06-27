package com.shop.controller;

import com.shop.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangeProfile", value = "/doChangeProfile")
public class ChangeProfileContronller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
            UserDao changeprofile = new UserDao();
            try {
                boolean set = changeprofile.changeProfile(userid, name, phoneNumber, email, address);
                if(set == true) {
                    request.setAttribute("Message", " Thông tin đã được cập nhật!!!");
                    RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
                    rd.forward(request, response);
                }
                else {
                    request.setAttribute("errMessage", "Sai định dạng !!!");
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
