package com.springboot.volidation.Entity;

import com.springboot.volidation.bean.validator.UserNamePrefix;
import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@PropertySource(value = "ValidationMessages_zh_CN.properties")
public class User {

    @NotNull
    private Long id;

    @UserNamePrefix(prefix = "123",message = "{user.name.message}")
    private String name;

    @Max(value = 100,message = "{Person.age.Max}")
    @Min(value = 1)
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
