package com.soren.controller;

import com.soren.model.Smartphone;
import com.soren.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/phone")
public class SmartphoneController {

    @Autowired
    SmartphoneService smartphoneService;

    @GetMapping("")
    public String getHome(Model model,
                          @PageableDefault(value = 3) Pageable pageable) {
        model.addAttribute("listSmartphone", this.smartphoneService.findAll(pageable));
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("smartphone", new Smartphone());
        return "phone/create";
    }

    @PostMapping("/create")
    public String createPhone(@ModelAttribute(name = "smartphone") Smartphone smartphone,
                              RedirectAttributes redirect) {
        this.smartphoneService.save(smartphone);
        redirect.addFlashAttribute("message", "Smartphone " + smartphone.getName() + " was added");
        return "redirect:/phone/";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam(name = "id") Integer id,
                               Model model) {
        model.addAttribute("smartphone", this.smartphoneService.findById(id));
        return "phone/edit";
    }

    @PostMapping("/edit")
    public String editPhone(Smartphone smartphone,
                            RedirectAttributes redirect) {
        this.smartphoneService.save(smartphone);
        redirect.addFlashAttribute("message", "Smartphone " + smartphone.getName() + " was updated");
        return "redirect:/phone/";
    }

    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam(name = "id") Integer id, Model model){
        model.addAttribute("smartphone", this.smartphoneService.findById(id));
        return "phone/delete";
    }

    @PostMapping("/delete")
    public String deletePhone(Integer id, RedirectAttributes redirect){
        Smartphone smartphone = this.smartphoneService.findById(id);
        if (smartphone != null){
            this.smartphoneService.deleteById(id);
            redirect.addFlashAttribute("message", "Smartphone "+smartphone.getName()+" was deleted");
        } else {
            redirect.addFlashAttribute("message", "Oops, Smartphone with ID "+id+" not found!");
        }
        return "redirect:/phone/";
    }

    @GetMapping("/view")
    public String viewPhone(@RequestParam(name = "id") Integer id, Model model){
        model.addAttribute("smartphone", this.smartphoneService.findById(id));
        return "phone/view";
    }
}
