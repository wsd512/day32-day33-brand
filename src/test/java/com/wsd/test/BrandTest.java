package com.wsd.test;

import com.wsd.pojo.Brand;
import com.wsd.service.BrandService;
import org.junit.Test;

import java.util.List;

/**
 * @program: wsd165
 * @description
 * @author: wansidong
 * @create: 2022-02-16 15:46
 */
public class BrandTest {

    private BrandService brandService = new BrandService();

    @Test
    public void testSelectAll(){
        List<Brand> brands = brandService.selectAll();
        brands.forEach(System.out::println);
    }

}
