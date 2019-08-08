package com.springboot.jpaDemo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "id_cards")
public class IdCard {

    @Id
    @GeneratedValue
    private Long id;


    @Column(length = 64)
    private String number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @OneToOne
    private Customer customer;
}
