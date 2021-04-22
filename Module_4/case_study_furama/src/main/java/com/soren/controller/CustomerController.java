package com.soren.controller;

import com.soren.model.Customer;
import com.soren.service.ContractService;
import com.soren.service.CustomerService;
import com.soren.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;
    @Autowired
    private ContractService contractService;

    @GetMapping("")
    public String getCustomerHome(Model model, @PageableDefault(value = 5) Pageable pageable){
        model.addAttribute("listCustomer", this.customerService.findAll(pageable));
        return "customer/customer_list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("listCustomerType", this.customerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/create")
    public String createCustomer(@Valid @ModelAttribute(name = "customer") Customer customer, BindingResult bindingResult,
                                 Model model, RedirectAttributes redirect){
        new Customer().validate(customer,bindingResult);
        this.customerService.checkCustomerId(customer, bindingResult);

        if (bindingResult.hasErrors()){
            model.addAttribute("customer", customer);
            model.addAttribute("listCustomerType", this.customerTypeService.findAll());
            return "customer/create";
        } else {
            this.customerService.save(customer);
            redirect.addFlashAttribute( "message",
                                        "Customer "+customer.getCustomerName()+" was added!");
            return "redirect:/customer/";
        }
    }

    @GetMapping("/view")
    public String viewCustomer(@RequestParam(name = "id") String id, Model model){
        Customer customer = this.customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/view";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam(name = "id") String id, Model model){
        Customer customer = this.customerService.findById(id);
        model.addAttribute("listCustomerType", this.customerTypeService.findAll());
        model.addAttribute("customer", customer);
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String editCustomer(@Valid Customer customer,BindingResult bindingResult,
                               Model model, RedirectAttributes redirect){

        new Customer().validate(customer,bindingResult);

        if (bindingResult.hasErrors()){
            model.addAttribute("listCustomerType", this.customerTypeService.findAll());
            model.addAttribute("customer", customer);
            return "customer/edit";
        } else {
            this.customerService.save(customer);
            redirect.addFlashAttribute("message","Information of Customer "+customer.getCustomerName()+" was updated!");
            return "redirect:/customer/";
        }
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

    @GetMapping("/search")
    public String searchCustomerByName(@RequestParam("search") Optional<String> search,
                                       @PageableDefault(value = 5) Pageable pageable,
                                       Model model){
        Page<Customer> listCustomer;
        if (search.isPresent()){
            model.addAttribute("search", search.get());
            listCustomer = this.customerService.findAllByCustomerNameContaining(search.get(), pageable);
        } else {
            listCustomer = this.customerService.findAll(pageable);
        }
        model.addAttribute("listCustomer", listCustomer);
        return "customer/customer_list";
    }

    @GetMapping("/using")
    public String showUsingCustomer(Model model, @PageableDefault(value = 5) Pageable pageable){
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        model.addAttribute("listUsingCustomer", this.contractService.getListUsingCustomer(date, pageable));
        return "customer/using";
    }
}