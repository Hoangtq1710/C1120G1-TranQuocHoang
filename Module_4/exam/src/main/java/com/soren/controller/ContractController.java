package com.soren.controller;

import com.soren.model.Contract;
import com.soren.model.ProductType;
import com.soren.service.ContractService;
import com.soren.service.ProductService;
import com.soren.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ContractController {

    @Autowired
    private ContractService contractService;
    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public String getHome(Model model, @PageableDefault(value = 5) Pageable pageable){
        model.addAttribute("listContract", this.contractService.findAll(pageable));
        return "list";
    }

    @PostMapping("/contract/checkList")
    public String getListFromTo(@RequestParam(name = "from") String from,
                                @RequestParam(name = "to") String to,
                                @PageableDefault(value = 5) Pageable pageable,
                                Model model){
        model.addAttribute("listContract",
                this.contractService.getListFromTo(from, to, pageable));
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        return "list";
    }

    @PostMapping("/contract/top")
    public String getTopContract(@RequestParam(name = "top") Integer top, Model model){
        model.addAttribute("listContract", this.contractService.getTopContract(top));
        model.addAttribute("top", top);
        return "top";
    }

    @GetMapping("/contract/edit")
    public String showEditForm(@RequestParam(name = "id") Integer id, Model model){
        Contract contract = this.contractService.findById(id);
        model.addAttribute("contract", contract);
        model.addAttribute("listProductType", this.productTypeService.findAll());
        model.addAttribute("listProduct", this.productService.findAll());
        return "edit";
    }

    @PostMapping("/contract/edit")
    public String editContract(@Valid @ModelAttribute(name = "contract") Contract contract, BindingResult bindingResult,
                               Model model, RedirectAttributes redirect,
                               @RequestParam(name = "type") Integer type){
        ProductType productType = this.productTypeService.findById(type);
        contract.getProduct().setProductType(productType);
        new Contract().validate(contract, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("type", type);
            model.addAttribute("contract", contract);
            model.addAttribute("listProductType", this.productTypeService.findAll());
            model.addAttribute("listProduct", this.productService.findAll());
            return "edit";
        } else {
            contract.setTotal(this.contractService.getTotal(contract));
            this.contractService.save(contract);
            redirect.addFlashAttribute("message", "Update success");
            return "redirect:/home";
        }
    }
}
