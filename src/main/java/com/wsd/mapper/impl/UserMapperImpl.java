package com.wsd.mapper.impl;

import com.wsd.mapper.UserMapper;
import com.wsd.pojo.User;
import com.wsd.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @program: wsd165
 * @description
 * @author: wansidong
 * @create: 2022-02-18 16:14
 */
public class UserMapperImpl implements UserMapper {
    @Override
    public User selectByUser(String username, String password) {
        //1.获取sqlsession对象
        SqlSession sqlSession = MyBatisUtils.getSession();
        //2.获取代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //3.调用接口中的方法
        User user = userMapper.selectByUser(username, password);
        //4.关闭会话
        sqlSession.close();

        return user;
    }

    @Override
    public User selectByUsername(String username) {
        //1.获取sqlsession会话对象
        SqlSession sqlSession = MyBatisUtils.getSession();

        //2.获取代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //3.调用方法
        User user = userMapper.selectByUsername(username);

        //4.关闭会话
        sqlSession.close();

        return user;
    }

    @Override
    public void registerUser(User user) {

        SqlSession sqlSession = MyBatisUtils.getSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.registerUser(user);

        sqlSession.commit();

        sqlSession.close();

    }

}
