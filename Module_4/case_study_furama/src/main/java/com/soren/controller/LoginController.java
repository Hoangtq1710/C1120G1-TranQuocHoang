package com.soren.controller;

import com.soren.model.User;
import com.soren.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User getLoginForm(){
        return new User();
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        return "loginPage";
    }

//    @PostMapping("/login/check")
//    public String checkLogin(Model model, Principal principal){
//        User user = (User) ((Authentication) principal).getPrincipal();
//        model.addAttribute("hiDirector",user.getUsername());
//
//        //fail thi tro lai trang login - success thi chuyen ve trang home
//        return "index";
//    }

    @GetMapping("/403")
    public String forbiddenPage(){
        return "403";
    }

    @GetMapping("/logout")
    public String logOut(){
        return "redirect:/home/";
    }
}
