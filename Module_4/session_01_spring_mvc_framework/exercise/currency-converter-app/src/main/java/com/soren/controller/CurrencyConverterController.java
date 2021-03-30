package com.soren.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConverterController {

    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }
    @GetMapping("/convert")
    public String convert(@RequestParam String from,@RequestParam String to,@RequestParam int currency, Model model){
        int rateIncome = 0;
        int rateOutcome = 0;
        switch (from) {
            case "usd":
                rateIncome = 23000;
                break;
            case "eur":
                rateIncome = 27000;
                break;
            case "vnd":
                rateIncome = 1;
                break;
            case "cad":
                rateIncome = 18200;
                break;
            case "gbp":
                rateIncome = 31600;
                break;
        }
        switch (to) {
            case "usd":
                rateOutcome = 23000;
                break;
            case "eur":
                rateOutcome = 27000;
                break;
            case "vnd":
                rateOutcome = 1;
                break;
            case "cad":
                rateOutcome = 18200;
                break;
            case "gbp":
                rateOutcome = 31600;
                break;
        }

        int result = currency * rateIncome / rateOutcome;
        model.addAttribute("currency",currency);
        model.addAttribute("from",from);
        model.addAttribute("to",to);
        model.addAttribute("result",result);
        return "index";
    }
}
