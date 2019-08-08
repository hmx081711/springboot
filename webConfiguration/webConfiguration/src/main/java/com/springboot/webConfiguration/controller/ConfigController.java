package com.springboot.webConfiguration.controller;

import com.springboot.webConfiguration.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * {@link Person} {@link RestController}
 @author mingxin Huang
 @see Person
 @since 1.0
 @create 2019/8/7
*/
@RestController
public class ConfigController {

    @Autowired
    private Person person;

    @Value("${person.id}")
    private Long id;

    @Value("${person.name}")
    private String name;

    @GetMapping("/config/person")
    public Person getPerson() {
        return person;
    }

    @GetMapping("/config/map")
    public Map<Long,String> getMap() {
        Map<Long,String> map = new HashMap<>();
        map.put(id,name);
        return map;
    }
}
