package com.fitchtree.postgresdemo.repository;

import com.fitchtree.postgresdemo.bean.Customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    
}