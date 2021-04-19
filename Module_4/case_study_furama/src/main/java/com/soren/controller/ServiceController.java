package com.soren.controller;

import com.soren.model.Service;
import com.soren.service.RentTypeService;
import com.soren.service.ServiceService;
import com.soren.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    ServiceService serviceService;

    @Autowired
    ServiceTypeService serviceTypeService;

    @Autowired
    RentTypeService rentTypeService;

    @GetMapping("")
    public String getServiceHome(Model model){
        model.addAttribute("listService", this.serviceService.findAll());
        return "service_list";
    }

    @GetMapping("/create")
    public String showCreateForm(@RequestParam("type") Integer type, Model model){
        model.addAttribute("type",type);
        model.addAttribute("listServiceType", this.serviceTypeService.findAll());
        model.addAttribute("listRentType", this.rentTypeService.findAll());
        model.addAttribute("service", new Service());
        return "service/create";
    }

    @PostMapping("/create")
    public String createService(Service service, RedirectAttributes redirect){
        service.setServiceName(this.serviceService.createServiceName(service));
        this.serviceService.save(service);
        redirect.addFlashAttribute("message", "Service "+service.getServiceName()+" was added!");
        return "redirect:/service/";
    }

    @GetMapping("/view")
    public String viewService(@RequestParam(name = "id") String id, Model model){
        Service service = this.serviceService.findById(id);
        model.addAttribute("service", service);
        return "service/view";
    }
}
