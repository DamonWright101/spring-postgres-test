package com.fitchtree.postgresdemo.controller;

import com.fitchtree.postgresdemo.service.CustomerService;
import com.fitchtree.postgresdemo.bean.Customer;

import java.io.IOException;
import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication(scanBasePackages = "com.fitchtree.postgresdemo.")
@RestController
@RequestMapping("/api")
public class CustomerApi {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private Customer customer;

    @RequestMapping(value = "/test")
    public String hello_index(Model model) {
        return "test page";
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @ResponseBody
    public Customer username_index(@PathVariable String username) {
        return this.customerService.byUsername(username);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> all_customers_index(Model model) {
        return this.customerService.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity create(@RequestBody Map<String, Object> payload) {
        if (customerService.createUser(payload) == false) 
            throw new IllegalArgumentException("the fields email,username,firstname and lastname are required");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"message\":\"accepted\"}");
    }

    @ExceptionHandler
    void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}