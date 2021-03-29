package com.soren.controller;

import com.soren.model.Customer;
import com.soren.service.CustomerService;
import com.soren.service.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {
    CustomerService customerService = new CustomerServiceImpl();

    @GetMapping("/customers")
    public String showList(Model model){
        List<Customer> listCustomer = this.customerService.findAll();
        model.addAttribute("listCustomer", listCustomer);
        return "/list";
    }

}
