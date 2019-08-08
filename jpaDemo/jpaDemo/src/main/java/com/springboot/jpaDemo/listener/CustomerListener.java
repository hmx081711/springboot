package com.springboot.jpaDemo.listener;


import javax.persistence.PrePersist;

public class CustomerListener{

    @PrePersist
    public void prePersist(Object source) {
        System.out.println(source);
    }
}
