package com.fitchtree.postgresdemo.service;

import com.fitchtree.postgresdemo.bean.Customer;
import com.fitchtree.postgresdemo.repository.CustomerRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
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

    public List<Customer> jsonToCustomerList(String jsonCustomers) {

        ObjectMapper mapper = beanFactory.getBean(ObjectMapper.class);
        try {
			return mapper.readValue(jsonCustomers, new TypeReference<List<Customer>>(){});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
        }
        return null;
    }
} 