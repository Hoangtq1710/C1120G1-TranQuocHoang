package com.soren.controller;

import com.soren.model.Cart;
import com.soren.model.Product;
import com.soren.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    Cart cart;

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public String addToCart(@RequestParam Integer id,
                           @RequestParam Integer amount){
        Product product = this.productService.findById(id);
        this.cart.addToCart(product, amount);
        return "redirect:/cart/";
    }

    @GetMapping("/")
    public String goToCart(Model model,
                           HttpServletRequest request,
                           HttpServletResponse response){

        Cookie cookie = new Cookie("cookieCart", this.cart.getCookieCart());
        cookie.setMaxAge(24*60*60);
        response.addCookie(cookie);



        model.addAttribute("cart", cart);
        model.addAttribute("cookieCart",cookie);
        model.addAttribute("listFromCart", this.cart.getListFromCart());
//        model.addAttribute("amount", amount);
        return "cart/cart";
    }
}
