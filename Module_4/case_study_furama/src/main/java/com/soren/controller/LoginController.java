package com.soren.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin(){
        return "loginPage";
    }

    @GetMapping("/404")
    public String hitErrorPage(){
        return "404";
    }

    @GetMapping("/403")
    public String hitForbiddenPage(){
        return "403";
    }

    @GetMapping("/logoutSuccessful")
    public String logOut(){
        return "loginPage";
    }
}
