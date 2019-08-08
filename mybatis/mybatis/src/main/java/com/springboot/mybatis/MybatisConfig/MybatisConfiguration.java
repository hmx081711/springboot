package com.springboot.mybatis.MybatisConfig;


import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import javax.sql.DataSource;

@Configuration
@ConditionalOnBean(DataSource.class)
public class MybatisConfiguration {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactoryBean createSqlSessionfactory() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:mybatis/mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(resource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer createMapperScanner() {
        MapperScannerConfigurer ms = new MapperScannerConfigurer();
        ms.setBasePackage("mapper");
        return ms;
    }
}
