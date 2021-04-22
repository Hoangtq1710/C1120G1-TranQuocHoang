package com.soren.controller;

import com.soren.model.Employee;
import com.soren.model.User;
import com.soren.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
import javax.validation.Valid;

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
        return "employee/employee_list";
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
    public String createEmployee(@Valid @ModelAttribute(name = "employee") Employee employee, BindingResult bindingResult,
                                 Model model,
                                 @RequestParam(name = "inputUsername") String inputUsername,
                                 RedirectAttributes redirect){
        new Employee().validate(employee, bindingResult);
        User user = this.userService.createUserByUsername(inputUsername);
        if (bindingResult.hasErrors()){
            model.addAttribute("listEducation", this.educationService.findAll());
            model.addAttribute("listDivision", this.divisionService.findAll());
            model.addAttribute("listPosition", this.positionService.findAll());
            model.addAttribute("inputUsername", inputUsername);
            model.addAttribute("employee", employee);
            return "employee/create";
        } else {
            if (user != null){
                employee.setUser(user);
            }
            //sau này sẽ else nếu validate tên username bị trùng
            this.employeeService.save(employee);
            redirect.addFlashAttribute("message", "Employee "+employee.getEmployeeName()+" was added!");
            return "redirect:/employee/";
        }
    }

    @GetMapping("/view")
    public String viewEmployee(@RequestParam(name = "id") Integer id, Model model){
        model.addAttribute("employee", this.employeeService.findById(id));
        return "employee/view";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam(name = "id") Integer id, Model model){
        model.addAttribute("listEducation", this.educationService.findAll());
        model.addAttribute("listDivision", this.divisionService.findAll());
        model.addAttribute("listPosition", this.positionService.findAll());
        model.addAttribute("employee", this.employeeService.findById(id));
        return "employee/edit";
    }

    @PostMapping("/edit")
    public String editEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult,
                               Model model,
                               @RequestParam(name = "newPassword") String newPassword,
                               RedirectAttributes redirect){
        new Employee().validate(employee, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("listEducation", this.educationService.findAll());
            model.addAttribute("listDivision", this.divisionService.findAll());
            model.addAttribute("listPosition", this.positionService.findAll());
            model.addAttribute("newPassword",newPassword);
            model.addAttribute("employee", employee);
            return "employee/edit";
        } else {
            this.userService.changePassword(employee.getUser(), newPassword);
            this.employeeService.save(employee);
            redirect.addFlashAttribute( "message",
                    "Information of Employee "+employee.getEmployeeName()+" was updated!");
            return "redirect:/employee/";
        }
    }

    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam(name = "id") Integer id, Model model){
        model.addAttribute("employee", this.employeeService.findById(id));
        return "employee/delete";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam(name = "employeeId") Integer id, RedirectAttributes redirect){
        Employee employee = this.employeeService.findById(id);
        employee.getUser().setEnabled(false); // set Enabled của account = 0
        this.employeeService.deleteById(id); // xóa Employee sẽ không xóa account của employee đó ,mà sẽ set Enabled = 0;
        redirect.addFlashAttribute( "message",
                                    "Employee "+employee.getEmployeeName()+" was deleted!");
        return "redirect:/employee/";
    }
}
