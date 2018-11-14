package com.fitchtree.postgresdemo.service;

import com.fitchtree.postgresdemo.bean.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {

    public List<Customer> findAll();
    public Customer byUsername(String username);
    public boolean createUser(Map<String, Object> newUser);
}