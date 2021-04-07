package com.soren.controller;

import com.soren.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PhoneNumberController {

    @GetMapping("")
    public String getHome(Model model){
        model.addAttribute("phoneNumber", new PhoneNumber());
        return "index";
    }

    @PostMapping("/validate")
    public String validatePhoneNumber(@Valid PhoneNumber phoneNumber, Model model, BindingResult bindingResult){
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasErrors()){
            return "index";
        } else {
            model.addAttribute("phoneNumber", phoneNumber);
            return "success";
        }
    }
}
