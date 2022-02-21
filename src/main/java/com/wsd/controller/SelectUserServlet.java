package com.wsd.controller;

import com.wsd.pojo.User;
import com.wsd.service.UserService;

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
 * @create: 2022-02-21 09:59
 */
@WebServlet("/SelectUserServlet")
public class SelectUserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        if(userService.selectUserByUsername(username)){
            out.print("用户名已经存在!");
        }else{
            out.print("可以注册!");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
