package com.wsd.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: wsd165
 * @description $description
 * @author: wansidong
 * @create: 2022-02-19 11:13
 */
@WebFilter(filterName = "CharacterEncodingFilter", urlPatterns = "/*")
public class CharacterEncodingFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        if (request.getMethod().equals("POST")) {
            request.setCharacterEncoding("utf-8");
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
    }

}
