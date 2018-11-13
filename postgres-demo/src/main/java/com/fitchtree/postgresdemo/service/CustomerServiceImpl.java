package com.fitchtree.postgresdemo.service;

import com.fitchtree.postgresdemo.bean.Customer;
import com.fitchtree.postgresdemo.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repo;

    @Override
    public List<Customer> findAll() {
        List<Customer> customer = (List<Customer>) repo.findAll();
        return customer;
    }
} 