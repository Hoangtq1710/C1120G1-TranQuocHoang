package com.soren.controller;

import com.soren.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("counter")
public class CounterController {

    @ModelAttribute("counter")
    public Counter counter(){
        return new Counter();
    }

    @GetMapping("/")
    public String getHome(@ModelAttribute("counter") Counter counter){
        counter.increment();
        return "index";
    }

}
