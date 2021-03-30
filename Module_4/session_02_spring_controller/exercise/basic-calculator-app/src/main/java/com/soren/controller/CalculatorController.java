package com.soren.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String getHome(){
        return "index";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam String first, @RequestParam String second, @RequestParam String calculation, Model model){
        double result = 0;
        double firstNumber = Double.parseDouble(first);
        double secondNumber = Double.parseDouble(second);
        switch (calculation){
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    model.addAttribute("message", "Can't divine by 0");
                }
                break;
        }
        model.addAttribute("first", first);
        model.addAttribute("second", second);
        model.addAttribute("calculation", calculation);
        model.addAttribute("result", result);
        return "index";
    }
}
