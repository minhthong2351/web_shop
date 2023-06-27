package com.shop.controller.admin;

import com.shop.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddAccount", value = "/AddAccount")
public class AddAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String suserid = request.getParameter("userid");
        String susername = request.getParameter("username");
        String spassword = request.getParameter("password");
        String sname = request.getParameter("name");
        String sphone = request.getParameter("phone");
        String semail = request.getParameter("email");
        String saddress = request.getParameter("address");
        String sstatus = request.getParameter("status");


        UserDao dao = new UserDao();
        dao.insertUser(suserid,susername,spassword,sname,sphone,semail,saddress,sstatus);
        response.sendRedirect("AccountAdmin");
    }

}
