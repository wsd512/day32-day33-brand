package com.wsd.filter;

import com.wsd.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: wsd165
 * @description
 * @author: wansidong
 * @create: 2022-02-19 11:22
 */
//@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        //将父接口转成子接口
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //把需要放行的地址添加到一个字符串数组中
        String[] urls = {"/login.jsp", "/imgs/", "/css/", "/loginServlet", "/register.jsp", "/registerServlet", "/checkCodeServlet","/SelectUserServlet","/js/"};
        System.out.println("访问的路径:" + request.getRequestURL());
        //遍历这个数组,进行判断用户访问的地址是否是包含这些地址呢
        for (String url : urls) {
            if (request.getRequestURL().toString().contains(url)) {
                chain.doFilter(request, response);
                return;
            }
        }

        //获取登录后的user用户信息
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //判断用户信息是否是为空,如果是空,则弹出提示信息,并且调回到登录页面
        if (user != null) {
            chain.doFilter(request, response);
        } else {
            out.print("<script>");
            out.print("alert('您还没登录哦,请先登录再访问咯!');");
            out.print("location.href='login.jsp';");
            out.print("</script>");
        }

    }

    @Override
    public void destroy() {

    }
}
