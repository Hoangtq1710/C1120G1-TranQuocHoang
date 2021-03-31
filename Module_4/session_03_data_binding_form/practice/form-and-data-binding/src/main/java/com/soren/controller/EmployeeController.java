package com.soren.controller;

import com.soren.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

    @GetMapping("/")
    public ModelAndView getHome(){
        return new ModelAndView("index", "employee", new Employee());
    }

    @PostMapping("/create")
    public ModelAndView createEmployee(@ModelAttribute Employee employee){
        return new ModelAndView("view", "employee", employee);
    }
}
