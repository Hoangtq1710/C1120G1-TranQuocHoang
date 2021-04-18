package com.soren.controller;

import com.soren.model.Customer;
import com.soren.service.CustomerService;
import com.soren.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("")
    public String getCustomerHome(Model model){
        model.addAttribute("listCustomer", this.customerService.findAll());
        return "customer_list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("listCustomerType", this.customerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/create")
    public String createCustomer(Customer customer, RedirectAttributes redirect){
        this.customerService.save(customer);
        redirect.addFlashAttribute("message","Customer "+customer.getCustomerName()+" was added!");
        return "redirect:/customer/";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam(name = "id") String id, Model model){
        Customer customer = this.customerService.findById(id);
        model.addAttribute("listCustomerType", this.customerTypeService.findAll());
        model.addAttribute("customer", customer);
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String editCustomer(Customer customer, RedirectAttributes redirect){
        this.customerService.save(customer);
        redirect.addFlashAttribute("message","Information of Customer "+customer.getCustomerName()+" was updated!");
        return "redirect:/customer/";
    }

    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam(name = "id") String id, Model model){
        Customer customer = this.customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/delete";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam(name = "customerId") String id, RedirectAttributes redirect){
        Customer customer = this.customerService.findById(id);
        this.customerService.deleteById(id);
        redirect.addFlashAttribute("message", "Customer "+customer.getCustomerName()+" was deleted!");
        return "redirect:/customer/";
    }
}