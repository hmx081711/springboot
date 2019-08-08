package com.hmx.springboot.controller;

import org.springframework.hateoas.ResourceSupport;

public class User extends ResourceSupport {
    private String Name;
    private Integer Age;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }
}
