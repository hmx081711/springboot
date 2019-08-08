package com.springboot.mybatis.controller;

import com.springboot.mybatis.Entity2.Stu;
import mapper.StuMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;

@RestController
public class Mybatis_boot2 {


    @Autowired
    private StuMapper stuMapper;

    @RequestMapping(value = "/mybatis2/{id}")
    public Stu selectById(@PathVariable(required = true) Integer id) {
        Stu stu = stuMapper.selectByPrimaryKey(id);
        return stu;
    }
}
