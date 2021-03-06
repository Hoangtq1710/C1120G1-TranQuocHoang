package com.soren.controller;

import com.soren.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    
    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/")
    public String getHome(){
        System.out.println("getHome");
        return "index";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam String first,
                             @RequestParam String second,
                             @RequestParam String operator,
                             Model model){
        double result = 0;
        try {
            result = this.calculatorService.calculate(first, second, operator);
        } catch (ArithmeticException e) {
            model.addAttribute("message", "Error : Can't divide by 0");
            System.out.println(e.getMessage());
        }

        model.addAttribute("first", first);
        model.addAttribute("second", second);
        model.addAttribute("operator", operator);
        model.addAttribute("result", result);
        return "index";
    }
}
