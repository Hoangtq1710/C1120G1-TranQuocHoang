package com.soren.controller;

import com.soren.model.Product;
import com.soren.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping({"", "/product"})
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String getHome(Model model){
        List<Product> listProduct = this.productService.findAll();
        model.addAttribute("listProduct", listProduct);
        return "index";
    }

    @GetMapping("/show_create")
    public String showCreate(Model model){
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/create")
    public String createProduct(Product product, RedirectAttributes redirect){
        this.productService.save(product);
        redirect.addFlashAttribute("message", "Product "+product.getName()+" was added");
        return "redirect:/product/";
    }

    @GetMapping("/view")
    public String viewProduct(@RequestParam Long id, Model model){
        Product product = this.productService.findById(id);
        model.addAttribute("product", product);
        return "product/view";
    }

    @GetMapping("/show_edit")
    public String showEdit(@RequestParam Long id, Model model){
        Product product = this.productService.findById(id);
        model.addAttribute("product", product);
        return "product/edit";
    }

    @PostMapping("/edit")
    public String editProduct(Product product, RedirectAttributes redirect){
        this.productService.save(product);
        redirect.addFlashAttribute("message", "Information of product "+product.getName()+" was updated");
        return "redirect:/product/";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Long id, RedirectAttributes redirect){
        this.productService.remove(id);
        redirect.addFlashAttribute("message", "Product was deleted!");
        return "redirect:/product/";
    }
}
