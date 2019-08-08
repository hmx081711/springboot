package com.springboot.jpaDemo.repository;

import com.springboot.jpaDemo.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

public class CustomerRepository extends SimpleJpaRepository<Customer,Long> {

    @Autowired
    public CustomerRepository(EntityManager em) {
        super(Customer.class,em);
    }
}
