package com.soren.controller;

import com.soren.model.Customer;
import com.soren.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping({"", "/customer"})
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public String getHome(Model model){
        List<Customer> listCustomer = this.customerService.findAll();
        model.addAttribute("listCustomer", listCustomer);
        return "index";
    }

    @GetMapping("/show_create")
    public String showCreate(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/create")
    public String createCustomer(Customer customer, RedirectAttributes redirect){
        this.customerService.save(customer);
        redirect.addFlashAttribute("message", "Customer "+customer.getName()+" was added");
        return "redirect:/customer/";
    }

    @GetMapping("/view")
    public String viewCustomer(@RequestParam int id, Model model){
        Customer customer = this.customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/view";
    }

    @GetMapping("/show_edit")
    public String showEdit(@RequestParam int id, Model model){
        Customer customer = this.customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/edit";
    }
}
