package com.soren.controller;

import com.soren.model.Email;
import com.soren.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmailController {

    @Autowired
    EmailService emailService;

    @GetMapping("/")
    public ModelAndView getHome(Model model){

        List<String> listLanguage = this.emailService.getListLanguage();
        List<Integer> listPageSize = this.emailService.getListPageSize();

        model.addAttribute("listLanguage", listLanguage);
        model.addAttribute("listPageSize", listPageSize);
        return new ModelAndView("index", "email", new Email());
    }

    @PostMapping("/email")
    public ModelAndView saveEmailConfiguration(@ModelAttribute Email email){
        this.emailService.save(email);
        return new ModelAndView("view", "email", email);
    }

    @GetMapping("/show-edit")
    public ModelAndView editEmailConfiguration(Model model){
        Email email = this.emailService.getEmailSetting();
        List<String> listLanguage = this.emailService.getListLanguage();
        List<Integer> listPageSize = this.emailService.getListPageSize();

        model.addAttribute("listLanguage", listLanguage);
        model.addAttribute("listPageSize", listPageSize);
        return new ModelAndView("edit","email", email);
    }

    @PostMapping("/edit-settings")
    public ModelAndView editSetting(@ModelAttribute Email email){
        this.emailService.update(email);
        return new ModelAndView("view", "email", email);
    }
}
