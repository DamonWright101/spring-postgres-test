package com.fitchtree.postgresdemo.controller;

import com.fitchtree.postgresdemo.service.CustomerService;
import com.fitchtree.postgresdemo.bean.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/api")
public class CustomerApi {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/test")
    public String hello_index(Model model) {
        return "test page";
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @ResponseBody
    public Customer username_index(@PathVariable String username) {
        System.out.println(this.customerService.byUsername(username));
        return this.customerService.byUsername(username);
    }
}