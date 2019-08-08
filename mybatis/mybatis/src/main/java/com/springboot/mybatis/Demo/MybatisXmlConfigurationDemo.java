package com.springboot.mybatis.Demo;

import com.springboot.mybatis.Entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;

/**
 * 使用Spring的api实现mybatis
 *
 */
public class MybatisXmlConfigurationDemo {


    public static void main(String[] args) throws IOException {

        ResourceLoader resourceLoader = new DefaultResourceLoader();

        Resource resource = resourceLoader.getResource("classpath:mybatis/mybatis-config.xml");

        EncodedResource encodedResource = new EncodedResource(resource);

        Reader reader = encodedResource.getReader();

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sessionFactory = builder.build(reader);

        SqlSession session = sessionFactory.openSession();

        Student stu = session.selectOne("demo",1);

        System.out.println(stu);


    }


}
