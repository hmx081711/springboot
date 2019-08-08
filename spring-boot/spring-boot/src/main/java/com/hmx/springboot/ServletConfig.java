package com.hmx.springboot;

import com.hmx.springboot.springboot_api.MyFilter2;
import com.hmx.springboot.springboot_api.MyServlet2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean httpServlet() {
        ServletRegistrationBean servlet = new ServletRegistrationBean();
        servlet.setName("MyServlet2");
        servlet.setServlet(new MyServlet2());
        servlet.addUrlMappings("/hello2");
        servlet.addInitParameter("myName","myValue");
        return servlet;
    }

    @Bean
    public FilterRegistrationBean filterConfig() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MyFilter2());
        registrationBean.addServletNames("MyServlet2");
        return registrationBean;
    }
}
