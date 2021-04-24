package com.soren.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {


    @GetMapping("/login")
    public String getLogin(){
        return "loginPage";
    }

    @GetMapping("/403")
    public String hitForbiddenPage(){
        return "403";
    }

    @GetMapping("/logout")
    public String logOut(){
        return "redirect:/home";
    }
}
