package com.wsd.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 会话工具类
 */
public class MyBatisUtils {

    /**
     * 会话工厂的创建类->会话工厂->会话
     */
    private static SqlSessionFactory factory;

    static {
        //1.会话工厂的创建类
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //2.得到配置文件的输入流
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")) {
            //3.创建会话工厂
            factory = builder.build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到会话对象
     * @return
     */
    public static SqlSession getSession() {
        return factory.openSession();
    }

    /**
     * 得到会话对象
     * @param openMode true表示自动提交事务，false表示手动提交事务
     */
    public static SqlSession getSession(boolean openMode) {
        return factory.openSession(openMode);
    }


}