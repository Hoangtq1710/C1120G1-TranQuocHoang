package com.soren.controller;

import com.soren.model.Product;
import com.soren.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String getHome(Model model){
        List<Product> listProduct = this.productService.findAll();
        model.addAttribute("listProduct",listProduct);
        return "index";
    }

    @GetMapping("/showCreate")
    public ModelAndView showCreateForm(){
        return new ModelAndView("create", "product", new Product());
    }

    @PostMapping("/create")
    public String createProduct(Product product, Model model, RedirectAttributes redirect){
        if (!this.productService.isExistId(product.getId())){
            this.productService.save(product);
            model.addAttribute("message", "Product "+product.getName()+" was added");
            return getHome(model);
        } else {
            redirect.addFlashAttribute("message", "ID "+product.getId()+" was existed!");
            return "redirect:/";
        }
    }

    @GetMapping("/showEdit")
    public ModelAndView showEditForm(@RequestParam int id){
        Product product = this.productService.findById(id);
        return new ModelAndView("edit", "product",product);
    }

    @PostMapping("/editProduct")
    public String editProduct(Product product, RedirectAttributes redirect){
        this.productService.update(product.getId(), product);
        redirect.addFlashAttribute("message", "Product "+product.getName()+" was edited");
        return "redirect:/";
    }

    @GetMapping("/view")
    public ModelAndView viewProduct(@RequestParam int id){
        Product product = this.productService.findById(id);
        return new ModelAndView("view", "product", product);
    }

    @GetMapping("/showDelete")
    public ModelAndView showDeleteForm(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("delete");
        Product product = this.productService.findById(id);
        modelAndView.addObject("confirm", "ARE YOU SURE TO DELETE PRODUCT WITH NAME : "+product.getName()+" ?");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam int id, RedirectAttributes redirect){
        Product product = this.productService.findById(id);
        redirect.addFlashAttribute("message", "Product "+product.getName()+" was deleted");
        this.productService.remove(id);
        return "redirect:/";
    }
}
