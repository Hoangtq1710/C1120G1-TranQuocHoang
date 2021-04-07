package com.soren.controller;

import com.soren.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("")
    public String getHome(Model model){
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/register")
    public String checkingUser(@Valid User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "index";
        } else {
            model.addAttribute("user", user);
            return "success";
        }
    }
}
