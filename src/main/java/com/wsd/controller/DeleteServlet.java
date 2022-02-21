package com.wsd.controller;

import com.wsd.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: wsd165
 * @description $description
 * @author: wansidong
 * @create: 2022-02-16 18:06
 */
@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {

    private BrandService brandService = new BrandService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");

        brandService.delete(Integer.parseInt(id));

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

//        out.write("<script>");
//        out.write("alert('删除成功!');");
//        out.write("location.href='index.jsp';");
//        out.write("</script>");

        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
