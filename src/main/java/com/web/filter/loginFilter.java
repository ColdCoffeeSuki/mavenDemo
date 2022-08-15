package com.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class loginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;

        //判断訪問資源路徑是否與登錄和注冊相關
        String[] urls = {"/login.jsp", "/signup.jsp", "/loginServlet", "/signupServlet"};
        //獲取當前訪問的資源路徑
        String url = req.getRequestURL().toString();
        for (String u : urls) {
            if (url.contains(u)) {
                chain.doFilter(request, response);
                return;
            }
        }

        //1.判断session中是否有user
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        //2.判断user是否為null
        if (user != null) {

        } else {
            req.setAttribute("login_msg", "You haven't logged in yet");
            req.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        //放行
        chain.doFilter(request, response);
    }
}
