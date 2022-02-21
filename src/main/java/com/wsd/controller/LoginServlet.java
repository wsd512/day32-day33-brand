package com.wsd.controller;

import com.wsd.pojo.User;
import com.wsd.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: wsd165
 * @description $description
 * @author: wansidong
 * @create: 2022-02-18 16:25
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码,以防获取的数据发生乱码
//        request.setCharacterEncoding("utf-8");
        //2.获取页面的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("用户名:" + username + ",密码:" + password);

        //3.调用service中的方法
        User user = userService.login(username, password);
        //设置响应的类型和编码
        response.setContentType("text/html;charset=utf-8");
        //得到字符输出流
        PrintWriter out = response.getWriter();

        if (user == null) {
            request.setAttribute("msg", "用户名或密码错误!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {

            String remember = request.getParameter("remember");
            if (remember != null) {

                Cookie cookieUser = new Cookie("user", username);
                cookieUser.setMaxAge(60 * 60 * 24 * 30);
                response.addCookie(cookieUser);

                Cookie cookiePassword = new Cookie("password", password);
                cookiePassword.setMaxAge(60 * 60 * 24 * 30);
                response.addCookie(cookiePassword);
            }

            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            out.print("<script>");
            out.print("alert('登录成功');");
            out.print("location.href='index.jsp';");
            out.print("</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
