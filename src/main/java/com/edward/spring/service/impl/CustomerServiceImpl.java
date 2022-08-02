package com.edward.spring.service.impl;

import com.edward.spring.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public int getCustomerById(int id) {
        System.out.println("Customer(id=" + id + ", name=Edward)");
        return ++id;
    }
}
