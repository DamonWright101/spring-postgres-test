package com.fitchtree.postgresdemo.controller;

import com.fitchtree.postgresdemo.service.CustomerService;
import com.fitchtree.postgresdemo.bean.Customer;
import com.fitchtree.postgresdemo.repository.CustomerRepository;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private BeanFactory beanFactory;

    @RequestMapping(value="/showCustomers")
    public String findCustomers(Model model) {
        List<Customer> customers = (List<Customer>) customerService.findAll();
        model.addAttribute("customers", customers);
        return "showCustomers";
    }

    @GetMapping(value="/createCustomer")
    public String createCustomersGet(Model model) {
        model.addAttribute("customer", beanFactory.getBean(Customer.class));
        return "createCustomer";
    }

    @GetMapping(value="/rabbit")
    public String rabbit(Model model) {
        model.addAttribute("customer", beanFactory.getBean(Customer.class));
        return "rabbitQueueTest";
    }

    @PostMapping(value="/createCustomer")
    public String createCustomersPost(@ModelAttribute Customer customer) {
        customerRepository.save(customer);
        return "createdCustomer";
    }


}