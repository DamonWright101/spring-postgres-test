package com.fitchtree.postgresdemo.service;

import com.fitchtree.postgresdemo.bean.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> findAll();
    public Customer byUsername(String username);
}