package com.soren.controller;

import com.soren.model.Cart;
import com.soren.model.Product;
import com.soren.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @ModelAttribute("cart")
    public Cart getCart(){
        return new Cart();
    }

    @Autowired
    ProductService productService;

    @GetMapping({"", "product"})
    public String getHome(Model model, @ModelAttribute("cart") Cart cart){
        model.addAttribute("listProduct", this.productService.findAll());
        model.addAttribute("size", cart.getSize());
        return "index";
    }

    @GetMapping("/product/view")
    public String viewProduct(@RequestParam Integer id, Model model){
        model.addAttribute("product", this.productService.findById(id));
        return "product/view";
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam Integer id,
                            @RequestParam Integer amount,
                            Model model,
                            @ModelAttribute("cart") Cart cart){
        Product product = this.productService.findById(id);
        model.addAttribute("product", product);
        if (product != null){
            cart.addToCart(product, amount);
            model.addAttribute("size", cart.getSize());
            model.addAttribute("message", "Add Product "+product.getName()+" with amount "+cart.getAmount(product)+" to Cart successfully");
        }
        return "product/view";
    }

    @GetMapping("/cart")
    public String goToCart(Model model,
                           @ModelAttribute("cart") Cart cart){
        model.addAttribute("listProduct", cart.getCart());
        return "cart/cart";
    }

    @PostMapping("/cart/remove")
    public String removeProductFromCart(@RequestParam Integer id,
                                        @ModelAttribute("cart") Cart cart,
                                        RedirectAttributes redirect){
        Product product = this.productService.findById(id);
        cart.removeProduct(product);
        redirect.addFlashAttribute("message", "Remove Product "+product.getName()+" successfully!");
        return "redirect:/cart";
    }



}
