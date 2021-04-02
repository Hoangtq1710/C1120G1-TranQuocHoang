package com.soren.controller;

import com.soren.entity.Customer;
import com.soren.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public String getHome(){
        List<Customer> listCustomer = this.customerService.findAll();
        return "index";
    }



}
