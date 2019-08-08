package com.springboot.mybatis.Demo;

import com.springboot.mybatis.Entity.Student;
import com.springboot.mybatis.Entity2.Stu;
import mapper.StuMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * 使用Spring的api实现mybatis
 *
 */
public class MybatisGeneratorConfigurationDemo {


    public static void main(String[] args) throws IOException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        InputStream inputStream = classLoader.getResourceAsStream("mybatis/mybatis-config.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        StuMapper stuMapper = session.getMapper(StuMapper.class);

        Stu stu = stuMapper.selectByPrimaryKey(1);

        System.out.println(stu);


    }


}
