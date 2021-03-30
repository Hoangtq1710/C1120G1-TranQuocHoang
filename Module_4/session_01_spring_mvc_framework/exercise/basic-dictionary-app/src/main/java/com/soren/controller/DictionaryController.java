package com.soren.controller;

import com.soren.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DictionaryController {

    @Autowired
    DictionaryService dictionaryService;

    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }

    @PostMapping("/translate")
    public String convert(@RequestParam String input, Model model){
        String result = this.dictionaryService.translate(input);
        List<String> listKey = this.dictionaryService.getAllKey();
        String message = "";
        if (result.equals("")) {
            message = "Oops, try another word!";
        }
        model.addAttribute("input",input);
        model.addAttribute("result", result);
        model.addAttribute("message", message);
        model.addAttribute("listKey",listKey);
        return "index";
    }
}
