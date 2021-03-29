package com.soren.controller;

import com.soren.model.Customer;
import com.soren.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public String getHomePage(ModelMap model){
        return "index";
    }
    @GetMapping("/customer")
    public String showList(Model model){
        List<Customer> listCustomer = this.customerService.findAll();
        model.addAttribute("listCustomer",listCustomer);
        return "show";
    }
    @GetMapping("/view")
    public String viewCustomer(@RequestParam int customerId, Model model) {
        Customer customer = this.customerService.findById(customerId);
        model.addAttribute("customer",customer);
        return "view";
    }
    @GetMapping("/showEdit")
    public String showEditForm(@RequestParam int customerId, Model model) {
        Customer customer = this.customerService.findById(customerId);
        model.addAttribute("customer", customer);
        return "edit";
    }
    @PostMapping("/edit")
    public String editCustomer(@RequestParam int id,@RequestParam String name,@RequestParam String email,@RequestParam String address, Model model){
        Customer customer = new Customer(id, name, email, address);
        this.customerService.update(id, customer);

        return showList(model);
    }
}
