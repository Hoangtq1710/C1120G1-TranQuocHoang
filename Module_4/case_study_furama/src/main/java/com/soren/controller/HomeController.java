package com.soren.controller;

import com.soren.model.Employee;
import com.soren.model.User;
import com.soren.service.EmployeeService;
import com.soren.service.UserRoleService;
import com.soren.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
@RequestMapping("")
@SessionAttributes("employeeSession")
public class HomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;

    @ModelAttribute("employeeSession")
    public Employee getEmployee(@CookieValue(name = "username", defaultValue = "") String username){
        if (username.equals("")){
            return new Employee();
        }
        return this.employeeService.findByUser(this.userService.findByUsername(username));
    }

    @GetMapping("")
    public String redirectToLoginFirst(){
        return "loginPage";
    }


    @GetMapping("/home")
    public String getHome(@CookieValue(name = "username") String username ,Principal principal,
                          Model model, HttpServletResponse response){
        String uName;
        if (principal == null){
            uName = username;
        } else {
            uName = principal.getName();
        }

        User user = this.userService.findByUsername(uName);
        Cookie cookie = new Cookie("username", uName);
        cookie.setMaxAge(3*60*60);
        response.addCookie(cookie);

        model.addAttribute("employeeSession", this.employeeService.findByUser(user));
        return "index";
    }
}
