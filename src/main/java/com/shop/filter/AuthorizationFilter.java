package com.shop.filter;


import com.shop.Util.SessionUtil;
import com.shop.beans.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "adminFilter", urlPatterns = { "/Admin" })
public class AuthorizationFilter implements Filter {
    private ServletContext context;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
            this.context=filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request =(HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url =request.getRequestURI();
        if(url.contains("/Admin")){
            User user = (User) SessionUtil.getInstance().getValue(request,"user");
            if(user!=null){
                if(user.isAdmin() != 0){
                    filterChain.doFilter(request,response);
                }else{
                    response.sendRedirect(request.getContextPath()+"/Index");
                }
            }else{
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
        }else{
            filterChain.doFilter(request,response);
        }

    }

    @Override
    public void destroy() {

    }
}
