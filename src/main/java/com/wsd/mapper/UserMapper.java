package com.wsd.mapper;

import com.wsd.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @program: wsd165
 * @description
 * @author: wansidong
 * @create: 2022-02-18 16:09
 */
public interface UserMapper {

    @Select("select * from tb_user where username=#{username} and password=#{password}")
    User selectByUser(@Param("username") String username, @Param("password") String password);

    @Select("select * from tb_user where username=#{username}")
    User selectByUsername(String username);

    @Insert("insert into tb_user values(null,#{username},#{password})")
    void registerUser(User user);

}
