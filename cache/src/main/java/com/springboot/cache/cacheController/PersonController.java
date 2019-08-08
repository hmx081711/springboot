package com.springboot.cache.cacheController;

import com.springboot.cache.entity.Person;
import com.springboot.cache.repository.PersonRespository;
import com.springboot.cache.repository.PersonRespositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonRespository personRespository;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Person savePerson(@RequestBody Person person) {
        personRespository.savePerson(person);
        return person;
    }

    @RequestMapping(value = "/get")
    public Person getPerson(String id) {
        return personRespository.findByid(id);
    }
}
