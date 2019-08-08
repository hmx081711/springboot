package com.springboot.jpaDemo.Entity;



import com.springboot.jpaDemo.listener.CustomerListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
@EntityListeners(value = CustomerListener.class)
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 64)
    private String name;

    @Column(length = 20)
    private Integer age;

    @OneToOne(mappedBy = "customer",cascade = CascadeType.REMOVE)
    private IdCard idCard;

    @ManyToOne
    private Store store;

    @ManyToMany
    private List<Books> books;

    public Store getStore() {
        return store;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public IdCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
