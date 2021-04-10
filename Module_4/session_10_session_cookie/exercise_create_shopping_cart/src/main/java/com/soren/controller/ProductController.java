package com.soren.controller;

import com.soren.model.Cart;
import com.soren.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping({"", "/product"})
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    Cart cart;

    @Autowired
    ProductService productService;

    @GetMapping("")
    public String getHome(Model model){
        model.addAttribute("listProduct", this.productService.findAll());
        return "index";
    }

    @GetMapping("/view")
    public String viewProduct(@RequestParam Integer id, Model model){
        model.addAttribute("product", this.productService.findById(id));
        return "product/view";
    }



}
