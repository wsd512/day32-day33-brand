package com.wsd.controller;

import com.wsd.pojo.Brand;
import com.wsd.service.BrandService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @program: wsd165
 * @description $description
 * @author: wansidong
 * @create: 2022-02-16 17:53
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {

    private BrandService brandService = new BrandService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        request.setCharacterEncoding("utf-8");

        Map<String, String[]> parameterMap = request.getParameterMap();

        Brand brand = new Brand();

        try {
            BeanUtils.populate(brand,parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        brandService.update(brand);

        response.sendRedirect("index.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
