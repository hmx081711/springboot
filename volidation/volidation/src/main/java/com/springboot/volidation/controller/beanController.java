package com.springboot.volidation.controller;

import com.springboot.volidation.Entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class beanController {

    @PostMapping("/save")
    public String save(@Valid @RequestBody User user) {

        return user.toString();
    }
}
