package com.wsd.service;

import com.wsd.mapper.UserMapper;
import com.wsd.mapper.impl.UserMapperImpl;
import com.wsd.pojo.User;

/**
 * @program: wsd165
 * @description
 * @author: wansidong
 * @create: 2022-02-18 16:17
 */
public class UserService {

    private UserMapper userMapper = new UserMapperImpl();

    public User login(String username,String password){
        User user = userMapper.selectByUser(username, password);
        return user;
    }

    public User selectByUsername(String username){
        User user = userMapper.selectByUsername(username);
        return user;
    }

    public void registerUser(User user){
        userMapper.registerUser(user);
    }

}
