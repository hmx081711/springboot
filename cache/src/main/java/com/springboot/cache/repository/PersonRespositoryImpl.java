package com.springboot.cache.repository;

import com.springboot.cache.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonRespositoryImpl implements PersonRespository{

    private final Map<String,Person> repository = new HashMap<>();

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Person findByid(String id) {
        //本地缓存
//        Person person = new Person();
//        try {
//            person = repository.get(id);
//        } finally {
//        }
//        return person;
        return (Person) redisTemplate.opsForValue().get(id);
    }

    @Override
    public boolean savePerson(Person person) {
        redisTemplate.opsForValue().set(person.getId().toString(),person);
        return true;
    }
}
