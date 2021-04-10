package com.soren.controller;

import com.soren.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class UserController {

    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @RequestMapping("/login")
    public String Index(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", cookie);
        return "login";
    }

    @PostMapping("/check_login")
    public String doLogin(@ModelAttribute("user") User user,
                          Model model,
                          @CookieValue(value = "setUser", defaultValue = "") String setUser,
                          HttpServletResponse response,
                          HttpServletRequest request) {

        if (user.getUsername().equals("hoang@gmail.com") && user.getPassword().equals("hoang")) {
            if (user.getUsername() != null)
                setUser = user.getUsername();

            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);

            Cookie[] cookies = request.getCookies();

            for (Cookie ck : cookies) {

                if (!ck.getName().equals("setUser")) {
                    ck.setValue("");
                }
                model.addAttribute("cookieValue", ck);
                break;
            }
            model.addAttribute("message", "Login successfully");
        } else {
            user.setUsername("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login failed! Check your username or password!");
        }
        return "login";
    }
}