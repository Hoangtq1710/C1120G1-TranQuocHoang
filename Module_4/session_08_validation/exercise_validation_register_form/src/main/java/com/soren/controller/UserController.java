package com.soren.controller;

import com.soren.model.User;
import com.soren.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public String getHome(Model model){
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/register")
    public String registeringUser(@Valid User user, BindingResult bindingResult,Model model){
        new User().validate(user, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("user", user);
            return "index";
        } else {
            this.userService.save(user);
            model.addAttribute("user", user);
            return "success";
        }
    }
}
