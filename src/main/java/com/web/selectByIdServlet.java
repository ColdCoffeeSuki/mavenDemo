package com.web;

import com.pojo.Brand;
import com.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectByIdServlet")
public class selectByIdServlet extends HttpServlet {
    BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收Id
        String id = request.getParameter("id");
        //2.調用service査詢
        Brand brand = service.selectById(Integer.parseInt(id));
        //3.存儲到request
        request.setAttribute("brand", brand);
        //4.轉發到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
