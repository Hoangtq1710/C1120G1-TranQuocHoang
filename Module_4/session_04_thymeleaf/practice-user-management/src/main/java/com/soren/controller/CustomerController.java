package com.soren.controller;

import com.soren.model.Customer;
import com.soren.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String getHomePage(Model model) {
        List<Customer> listCustomer = customerService.findAll();
        model.addAttribute("listCustomer", listCustomer);
        return "index";
    }

    @GetMapping("/customer/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/customer/save")
    public String save(Customer customer, RedirectAttributes redirect) {
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Added customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/customer/edit")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "edit";
    }

    @PostMapping("/customer/update")
    public String update(Customer customer, RedirectAttributes redirect) {
        customerService.update(customer.getId(),customer);
        redirect.addFlashAttribute("message", "Updated customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/customer/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirect) {
        customerService.remove(customerService.findById(id).getId());
        redirect.addFlashAttribute("message", "Removed customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/customer/view")
    public String view(@RequestParam int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "view";
    }
}