package com.soren.controller;

import com.soren.model.Employee;
import com.soren.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private DivisionService divisionService;
    @Autowired
    private EducationDegreeService educationService;
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String getEmployeeHome(@PageableDefault(value = 5) Pageable pageable,
                                  Model model){
        model.addAttribute("listEmployee", this.employeeService.findAll(pageable));
        return "employee_list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("listEducation", this.educationService.findAll());
        model.addAttribute("listDivision", this.divisionService.findAll());
        model.addAttribute("listPosition", this.positionService.findAll());
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping("/create")
    public String createEmployee(@ModelAttribute(name = "employee") Employee employee,
                                 @RequestParam(name = "inputUsername") String username,
                                 RedirectAttributes redirect){
        employee.setUser(this.userService.createUserByUsername(username));
        this.employeeService.save(employee);
        redirect.addFlashAttribute("message", "Employee "+employee.getEmployeeName()+" was added!");
        return "redirect:/employee/";
    }

    @GetMapping("/view")
    public String viewEmployee(@RequestParam(name = "id") Integer id, Model model){
        model.addAttribute("employee", this.employeeService.findById(id));
        return "employee/view";
    }
}
