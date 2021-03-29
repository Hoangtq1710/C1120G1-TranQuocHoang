package com.soren.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Pattern;

@Controller
public class EmailController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }

    @GetMapping("/email")
    public String validateEmail(@RequestParam String email, Model model){
        if (!validate(email)) {
            model.addAttribute("message", "Invalid EMAIL");
            model.addAttribute("email",email);
            return "index";
        }
        model.addAttribute("email",email);
        return "success";
    }

    private boolean validate(String email){
        return Pattern.matches(EMAIL_REGEX,email);
    }
}
