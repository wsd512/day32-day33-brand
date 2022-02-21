package com.wsd.mapper;

import com.wsd.pojo.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: wsd165
 * @description
 * @author: wansidong
 * @create: 2022-02-16 15:01
 */
public interface BrandMapper {

    @Select("select * from tb_brand")
    List<Brand> selectAll();

    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void addBrand(Brand brand);

    @Select("select * from tb_brand where id=#{id}")
    Brand selectById(Integer id);

    @Select("update tb_brand set brand_name=#{brandName},company_name=#{companyName},ordered=#{ordered},description=#{description},status=#{status} where id=#{id}")
    void update(Brand brand);

    @Delete("delete from tb_brand where id=#{id}")
    void delete(Integer id);

}
