package com.hmx.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class RestDemoController {

    @Bean
    public User currentUser() {
        User user = new User();
        user.setAge(19);
        user.setName("Jack");
        return user;
    }

    @Autowired
    @Qualifier(value = "currentUser")
    private User user;

    @RequestMapping(value = "/demo")
    public String helloWorld() {
        return "hello,world!";
    }

    @RequestMapping(value = "/demo1/{num}")
    public String htmlCode(@PathVariable String num,@RequestParam(value = "p",defaultValue = "31") String num2) {
        return "num="+num+num2;
    }

    @RequestMapping(value = "/header/{num}")
    public String htmlHeader(@RequestHeader(value = "Accept") String num) {
        return "Accept" + num;
    }

    @RequestMapping(value = "/entity/{num}",consumes = {},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> htmlEntity() {
        return ResponseEntity.ok("<html><body>ok</body></html>");
    }

    @RequestMapping(value = "/json",produces = MediaType.APPLICATION_JSON_VALUE)
    public User htmlJson() {
        User user = new User();
        user.setAge(19);
        user.setName("Jack");
        return user;
    }

    @GetMapping(value = "/hateAos/user",produces = MediaType.APPLICATION_JSON_VALUE)
    public User user() {
        user.add(linkTo(methodOn(RestDemoController.class).setName(user.getName())).withSelfRel());
        user.add(linkTo(methodOn(RestDemoController.class).setAge(user.getAge())).withSelfRel());
        return user;
    }
    @GetMapping(value = "/hateAos/json/name",produces = MediaType.APPLICATION_JSON_VALUE)
    public User setName(@RequestParam(value = "name") String name) {
        user.setName(name);
        return user;
    }

    @GetMapping(value = "/hateAos/json/age",produces = MediaType.APPLICATION_JSON_VALUE)
    public User setAge(@RequestParam(value = "age") Integer age) {
        user.setAge(age);
        return user;
    }

    @RequestMapping(value = "/xml",
            produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public User htmlXML() {
        User user = new User();
        user.setAge(19);
        user.setName("Tom");
        return user;
    }
}
