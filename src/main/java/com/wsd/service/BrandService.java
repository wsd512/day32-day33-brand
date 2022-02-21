package com.wsd.service;

import com.wsd.mapper.BrandMapper;
import com.wsd.mapper.impl.BrandMapperImpl;
import com.wsd.pojo.Brand;

import java.util.List;

/**
 * @program: wsd165
 * @description
 * @author: wansidong
 * @create: 2022-02-16 15:07
 */
public class BrandService {

    private BrandMapper brandMapper = new BrandMapperImpl();

    public List<Brand> selectAll(){
        List<Brand> brands = brandMapper.selectAll();
        return brands;
    }

    public void addBrand(Brand brand){
        brandMapper.addBrand(brand);
    }

    public Brand selectById(Integer id){
        Brand brand = brandMapper.selectById(id);
        return brand;
    }

    public void update(Brand brand){
        brandMapper.update(brand);
    }

    public void delete(Integer id){
        brandMapper.delete(id);
    }

}
