package com.springboot.jpaDemo.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue
    private Long id;


    @Column(name = "store_name",length = 20)
    private String storeName;


    @Column(length = 40)
    private String address;

    @OneToMany(mappedBy = "id",cascade = CascadeType.REMOVE)
    private List<Customer> customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }
}
