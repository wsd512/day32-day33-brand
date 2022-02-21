package com.wsd.controller;

import com.wsd.utils.CheckCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @program: wsd165
 * @description $description
 * @author: wansidong
 * @create: 2022-02-18 17:30
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String code = CheckCodeUtil.generateVerifyCode(4);
        System.out.println("验证码是:" + code);
        CheckCodeUtil.outputImage(100, 50, response.getOutputStream(), code);
        HttpSession session = request.getSession();
        session.setAttribute("code",code);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
