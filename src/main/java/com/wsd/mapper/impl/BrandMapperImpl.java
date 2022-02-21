package com.wsd.mapper.impl;

import com.wsd.mapper.BrandMapper;
import com.wsd.pojo.Brand;
import com.wsd.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @program: wsd165
 * @description
 * @author: wansidong
 * @create: 2022-02-16 15:04
 */
public class BrandMapperImpl implements BrandMapper{

    @Override
    public List<Brand> selectAll() {

        SqlSession sqlSession = MyBatisUtils.getSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectAll();

        sqlSession.close();

        return brands;
    }

    @Override
    public void addBrand(Brand brand) {
        SqlSession sqlSession = MyBatisUtils.getSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.addBrand(brand);

        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public Brand selectById(Integer id) {
        SqlSession sqlSession = MyBatisUtils.getSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brands = brandMapper.selectById(id);

        sqlSession.close();

        return brands;
    }

    @Override
    public void update(Brand brand) {
        SqlSession sqlSession = MyBatisUtils.getSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.update(brand);

        sqlSession.commit();

        sqlSession.close();

    }

    @Override
    public void delete(Integer id) {
        SqlSession sqlSession = MyBatisUtils.getSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.delete(id);

        sqlSession.commit();

        sqlSession.close();
    }
}
