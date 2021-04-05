package com.soren.ss06_practice_customer.controller;

import com.soren.ss06_practice_customer.model.Customer;
import com.soren.ss06_practice_customer.serivce.CustomerService;
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
        model.addAttribute("listCustomer",listCustomer);
        return "index";
    }

    @GetMapping("/show_create")
    public String showCreateForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/create")
    public String createCustomer(Customer customer, RedirectAttributes redirect){
        this.customerService.save(customer);
        redirect.addFlashAttribute("message", "Customer "+customer.getName()+" was added");
        return "redirect:/customer/";
    }

    @GetMapping("/show_edit")
    public String showEditForm(@RequestParam Integer id, Model model){
        Customer customer = this.customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String editCustomer(Customer customer, RedirectAttributes redirect){
        this.customerService.save(customer);
        redirect.addFlashAttribute("message", "Information of Customer "+customer.getName()+" was updated");
        return "redirect:/customer/";
    }

    @GetMapping("/view")
    public String viewCustomer(@RequestParam Integer id, Model model){
        Customer customer = this.customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/view";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam Integer id, RedirectAttributes redirect){
        Customer customer = this.customerService.findById(id);
        if (customer != null){
            this.customerService.deleteById(id);
            redirect.addFlashAttribute("message", "Customer "+customer.getName()+" was deleted");
        }
        return "redirect:/customer/";
    }
}
