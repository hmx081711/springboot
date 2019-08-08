package com.springboot.jpaDemo.controller;

import com.springboot.jpaDemo.Entity.Customer;
import com.springboot.jpaDemo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Customer addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        Customer c = customerService.findCustomer(customer.getId());
        return c;
    }
}
