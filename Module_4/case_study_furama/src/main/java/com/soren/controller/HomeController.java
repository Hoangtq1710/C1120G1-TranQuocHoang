package com.soren.controller;

import com.soren.model.Employee;
import com.soren.model.User;
import com.soren.service.EmployeeService;
import com.soren.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;

@Controller
@RequestMapping("/")
@SessionAttributes("employeeSession")
public class HomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;

    @ModelAttribute("employeeSession")
    public Employee getEmployee(Principal principal){
        String username = principal.getName();
        return this.employeeService.findByUser(this.userService.findByUsername(username));
    }

    @GetMapping("")
    public String redirectToLoginFirst(){
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String getHome(Principal principal, Model model){
        String username = principal.getName();
        User user = this.userService.findByUsername(username);
        model.addAttribute("employeeSession", this.employeeService.findByUser(user));
        return "index";
    }
}
