package com.fitchtree.postgresdemo.controller;

import com.fitchtree.postgresdemo.service.CustomerService;
import com.fitchtree.postgresdemo.bean.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value="/showCustomers")
    public String findCustomers(Model model) {
        List<Customer> customers = (List<Customer>) customerService.findAll();
        model.addAttribute("customers", customers);
        return "showCustomers";
    }

}