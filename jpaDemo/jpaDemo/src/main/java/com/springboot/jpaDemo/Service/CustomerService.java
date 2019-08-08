package com.springboot.jpaDemo.Service;

import com.springboot.jpaDemo.Entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

@Service
public class CustomerService {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 添加用户
     * @param customer 用户名
     *
     */
    @Transactional
    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    public Customer findCustomer(Long id) {
        return entityManager.find(Customer.class,id);
    }
}
