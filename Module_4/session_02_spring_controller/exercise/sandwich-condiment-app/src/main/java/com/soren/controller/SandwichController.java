package com.soren.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class SandwichController {

    @GetMapping("/")
    public String getHome(){
        return "index";
    }
    @GetMapping("/sandwich")
    public String getCondimentSandwich(@RequestParam String[] condiment, Model model){
        List<String> listCondiment = Arrays.asList(condiment);
        model.addAttribute("listCondiment", listCondiment);
        return "condiment";
    }
}
