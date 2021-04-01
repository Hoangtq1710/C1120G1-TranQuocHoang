package com.soren.controller;

import com.soren.model.Customer;
import com.soren.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public ModelAndView getHome(){
        List<Customer> listCustomer = this.customerService.findAll();
        return new ModelAndView("index","listCustomer",listCustomer);
    }

    @GetMapping("/show-create")
    public ModelAndView showCreateForm(){
        return new ModelAndView("create","customer", new Customer());
    }

    @PostMapping("/create-customer")
    public ModelAndView createCustomer(Customer customer){
        ModelAndView modelAndView = new ModelAndView();
        if (!this.customerService.isExistId(customer.getId())){
            modelAndView.addObject("messageCreate", "Customer was added");
            this.customerService.save(customer);
            return getHome();
        } else {
            modelAndView.addObject("message", "Exist ID");
            modelAndView.addObject("customer", customer);
            modelAndView.setViewName("create");
            return modelAndView;
        }
    }

    @GetMapping("/show-edit")
    public ModelAndView showEditForm(@RequestParam int id){
        Customer customer = this.customerService.findById(id);
        return new ModelAndView("show-edit", "customer",customer);
    }

    @PostMapping("/edit-customer")
    public ModelAndView editCustomer(Customer customer, ModelAndView modelAndView){
        this.customerService.update(customer.getId(), customer);
        modelAndView.addObject("messageUpdate","Customer information was updated");
        return getHome();
    }

}
