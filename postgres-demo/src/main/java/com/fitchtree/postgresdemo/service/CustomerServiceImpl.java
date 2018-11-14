package com.fitchtree.postgresdemo.service;

import com.fitchtree.postgresdemo.bean.Customer;
import com.fitchtree.postgresdemo.repository.CustomerRepository;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BeanFactory beanFactory;

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        return customers;
    }

    public Customer byUsername(String username) {
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        for (Customer cs: customers) {
            if (cs.getUsername().equals(username)) return cs;
        }
        return null;
    }

    public boolean createUser(Map<String, Object> newUser) {
        if (!newUser.keySet().contains("email") 
            || !newUser.keySet().contains("username")
            || !newUser.keySet().contains("firstname")
            || !newUser.keySet().contains("lastname")) return false;
        Customer customer = beanFactory.getBean(Customer.class);
        customer.setEmail((String) newUser.get("email"));
        customer.setUsername((String) newUser.get("username"));
        customer.setFirstname((String) newUser.get("firstname"));
        customer.setLastname((String) newUser.get("lastname"));
        customerRepository.save(customer);
        return true;
    }
} 