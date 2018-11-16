package com.fitchtree.postgresdemo.controller;

import com.fitchtree.postgresdemo.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fitchtree.postgresdemo.Endpoints.ApiConnectors;
import com.fitchtree.postgresdemo.amqp.Order;
import com.fitchtree.postgresdemo.amqp.OrderMessageSender;
import com.fitchtree.postgresdemo.bean.Customer;
import com.fitchtree.postgresdemo.repository.CustomerRepository;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication(scanBasePackages = "com.fitchtree.postgresdemo.")
@Controller
public class MyController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    public ApiConnectors apiConnectors;

    @RequestMapping(value="/showCustomers")
    public String findCustomers(Model model) {
        
        List<Customer> customers = customerService.jsonToCustomerList(apiConnectors.getJsonFromApi("/api/customers"));
        model.addAttribute("customers", customers);
        return "showCustomers";
    }

    @GetMapping(value="/rabbit")
    public String rabbitGet(Model model) {
        model.addAttribute("order", beanFactory.getBean(Order.class));
        return "rabbit";
    }

    @PostMapping(value="/rabbit")
    public String rabbitPost(@ModelAttribute Order order) {
        OrderMessageSender orderMessageSender = beanFactory.getBean(OrderMessageSender.class);
        orderMessageSender.sendOrder(order);
        return "rabbit";
    }

    @GetMapping(value="/createCustomer")
    public String createCustomersGet(Model model) {
        model.addAttribute("customer", beanFactory.getBean(Customer.class));
        return "createCustomer";
    }

    @PostMapping(value="/createCustomer")
    public String createCustomersPost(@ModelAttribute Customer customer) {
        customerRepository.save(customer);
        return "createdCustomer";
    }

}