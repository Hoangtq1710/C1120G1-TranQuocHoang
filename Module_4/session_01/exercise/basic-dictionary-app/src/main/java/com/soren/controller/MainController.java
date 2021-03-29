package com.soren.controller;

import com.soren.repository.DictionaryRepository;
import com.soren.repository.DictionaryRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    DictionaryRepository repository = new DictionaryRepositoryImpl();

    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }
    @PostMapping("/translate")
    public String convert(@RequestParam String input, Model model){
        String result = repository.translate(input);
        String message = "";
        if (result.equals("")) {
            message = "Oops, try another word!";
        }
        model.addAttribute("input",input);
        model.addAttribute("result", result);
        model.addAttribute("message", message);
        return "index";
    }
}
