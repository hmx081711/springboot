package com.springboot.mybatis.controller;

import com.springboot.mybatis.Entity2.Stu;
import mapper.StuMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mybatis_boot {

//    @Autowired
//    private SqlSessionTemplate sqlSessionTemplate;


//    @RequestMapping(value = "/mybatis/{id}")
//    public Stu selectById(@PathVariable(required = true) Integer id) {
//        StuMapper stuMapper = sqlSessionTemplate.getMapper(StuMapper.class);
//        Stu stu = stuMapper.selectByPrimaryKey(id);
//        return stu;
//    }
}
