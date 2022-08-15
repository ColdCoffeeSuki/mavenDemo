package com.web;

import com.pojo.User;
import com.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/signupServlet")
public class signupServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(null, username, password);
        boolean signupFlag = service.signup(user);
        if(signupFlag){
            request.setAttribute("signup_msg", "��������");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }else {
            request.setAttribute("signup_msg", "�p�˖��ߑ���");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
