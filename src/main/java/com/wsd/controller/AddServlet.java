package com.wsd.controller;

import com.alibaba.fastjson.JSON;
import com.wsd.pojo.Brand;
import com.wsd.service.BrandService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @program: wsd165
 * @description $description
 * @author: wansidong
 * @create: 2022-02-16 17:07
 */
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

    private BrandService brandService = new BrandService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");

//        Map<String, String[]> parameterMap = request.getParameterMap();
//
//        Brand brand = new Brand();
//
//        try {
//            BeanUtils.populate(brand,parameterMap);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //1.获取字符缓冲流
        BufferedReader reader = request.getReader();

        String json = reader.readLine();

        Brand brand = JSON.parseObject(json, Brand.class);

        brandService.addBrand(brand);

        response.setContentType("text/plain;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("success");

//        response.sendRedirect("index.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
