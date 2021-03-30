package com.soren.controller;

import com.soren.model.Login;
import com.soren.model.User;
import com.soren.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public ModelAndView getHome(){
        return new ModelAndView("index", "login", new Login());
    }

    @PostMapping("/login")
    public ModelAndView checkLogin(@ModelAttribute Login login){
        User user = this.userService.checkLogin(login);
        ModelAndView modelAndView;
        if (user == null) {
            modelAndView = new ModelAndView("index");
            modelAndView.addObject("message", "That was an invalid username or password. Give it another try.");
        } else {
            modelAndView = new ModelAndView("user");
            modelAndView.addObject("user", user);
        }
        return modelAndView;
    }
}
