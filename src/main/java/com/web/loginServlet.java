package com.web;

import com.pojo.User;
import com.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.ws.Service;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        User user = service.login(username, password);

        if (user != null) {
            //登錄成功
            if ("1".equals(remember)) {
                //1.創建cookie對象
                Cookie c_username = new Cookie("username", username);
                Cookie c_password = new Cookie("password", password);

                //設置cookie存活時間（單位 秒）
                c_username.setMaxAge(60 * 60);
                c_password.setMaxAge(60 * 60);
                //2.發送
                response.addCookie(c_username);
                response.addCookie(c_password);
            }
            //將成功登錄的user對象存儲到session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/selectAllServlet");
        } else {
            request.setAttribute("login_msg", "Wrong user name or password");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
