package com.soren.controller;

import com.soren.model.User;
import com.soren.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
@SessionAttributes("user")
public class LoginController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User getLoginForm(){
        return new User();
    }

    @GetMapping("")
    public String getLogin(){
        return "loginPage";
    }

    @PostMapping("")
    public String checkLogin(@Valid @ModelAttribute(name = "user") User user, BindingResult bindingResult,
                             Model model){
        if (this.userService.checkUser(user, bindingResult)) {
            if (!bindingResult.hasErrors()){
                return "redirect:/";
            }
        }
        model.addAttribute("user", user);
        return "loginPage";
    }
}
