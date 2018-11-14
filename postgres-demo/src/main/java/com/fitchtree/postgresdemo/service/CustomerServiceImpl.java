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
        List<Customer> customers = (List<Customer>) repo.findAll();
        return customers;
    }

    public Customer byUsername(String username) {
        List<Customer> customers = (List<Customer>) repo.findAll();
        for (Customer customer: customers) {
            if (customer.getUsername().equals(username)) return customer;
        }
        return null;
    }
} 