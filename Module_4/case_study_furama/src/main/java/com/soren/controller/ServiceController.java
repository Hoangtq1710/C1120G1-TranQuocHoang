package com.soren.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service")
public class ServiceController {

    @GetMapping("")
    public String getServiceHome(Model model){
        return "service_list";
    }
}
