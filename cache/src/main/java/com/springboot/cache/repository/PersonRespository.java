package com.springboot.cache.repository;

import com.springboot.cache.entity.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonRespository {

    @Cacheable(cacheNames="persons")
    Person findByid(String id);

    boolean savePerson(Person person);
}
