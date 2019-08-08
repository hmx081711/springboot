package com.springboot.jpaDemo.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Books {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "book_name")
    private String bookName;

    @ManyToMany(mappedBy = "books")
    private List<Customer> customerList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomers(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
