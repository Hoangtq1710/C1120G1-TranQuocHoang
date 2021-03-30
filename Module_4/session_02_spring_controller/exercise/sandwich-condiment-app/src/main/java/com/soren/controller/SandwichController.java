package com.soren.controller;

import com.soren.service.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class SandwichController {

    @Autowired
    SandwichService sandwichService;

    @GetMapping("/")
    public String getHome(){
        return "index";
    }

    @GetMapping("/sandwich")
    public String getCondimentSandwich(@RequestParam String[] condiments, Model model){
        List<String> listCondiment = this.sandwichService.getListCondiment(condiments);
        model.addAttribute("listCondiment", listCondiment);
        return "condiment";
    }
}
