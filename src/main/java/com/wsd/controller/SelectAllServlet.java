package com.wsd.controller;

import com.alibaba.fastjson.JSON;
import com.wsd.pojo.Brand;
import com.wsd.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @program: wsd165
 * @description $description
 * @author: wansidong
 * @create: 2022-02-16 15:09
 */
@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {

    private BrandService brandService = new BrandService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.查收所有的品牌信息
        List<Brand> brands = brandService.selectAll();
        //2.把所有的品牌信息转换成JSON字符串
        String jsonString = JSON.toJSONString(brands);
        //3.把JSON字符串打印到浏览器上
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(jsonString);
//        request.setAttribute("brands",brands);
//        request.getRequestDispatcher("/brandList.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
