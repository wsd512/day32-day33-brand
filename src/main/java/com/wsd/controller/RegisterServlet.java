package com.wsd.controller;

import com.wsd.pojo.User;
import com.wsd.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @program: wsd165
 * @description $description
 * @author: wansidong
 * @create: 2022-02-18 16:41
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        User byUsername = userService.selectByUsername(user.getUsername());


        if (byUsername != null) {
            request.setAttribute("msg", "用户名已经存在");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {

            String checkCode = request.getParameter("checkCode");
            HttpSession session = request.getSession();
            String code = (String) session.getAttribute("code");

            session.removeAttribute("code");

            System.out.println("checkCode = " + checkCode);
            if(checkCode.length()==0){
                System.out.println("验证码不能为空" );
                out.print("<script>");
                out.print("alert('验证码不能为空!');");
                out.print("location.href='register.jsp'");
                out.print("</script>");
            }


            if (!checkCode.equalsIgnoreCase(code)) {
                request.setAttribute("msg", "验证码不正确!");
                return;
            }



            userService.registerUser(user);
            out.print("<script>");
            out.print("alert('注册成功!');");
            out.print("location.href='login.jsp'");
            out.print("</script>");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
