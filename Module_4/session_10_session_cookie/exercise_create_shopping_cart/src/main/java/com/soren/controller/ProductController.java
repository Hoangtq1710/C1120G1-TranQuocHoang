package com.soren.controller;

import com.soren.model.Cart;
import com.soren.model.Product;
import com.soren.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;


@Controller
@SessionAttributes("cart")
public class ProductController {

    @ModelAttribute("cart")
    public Cart cart(){
        return new Cart();
    }

    @Autowired
    ProductService productService;

    @GetMapping({"", "product"})
    public String getHome(Model model,
                          @CookieValue(value = "cookieCart", defaultValue = "") String cookieCart,
                          HttpServletResponse response){
        Cookie cookie = new Cookie("cookieCart",cookieCart );
        cookie.setMaxAge(3*60*60);
        response.addCookie(cookie);

        model.addAttribute("cookieCart", cookie);
        model.addAttribute("listProduct", this.productService.findAll());
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
                            HttpServletResponse response,
                            Model model,
                            @ModelAttribute("cart") Cart cart){
        Product product = this.productService.findById(id);
        cart.addToCart(product, amount);
        String cookieCart = cart.getCookieCart();
        Cookie cookie = new Cookie("cookieCart",cookieCart );
        cookie.setMaxAge(3*60*60);
        response.addCookie(cookie);

        model.addAttribute("cookieCart", cookieCart);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String goToCart(Model model,
                           HttpServletRequest request,
                           @ModelAttribute("cart") Cart cart){

        Cookie[] cookies = request.getCookies();
        for(Cookie ck : cookies){
            if (ck.getName().equals("cookieCart")){
                model.addAttribute("cookieCart",ck.getValue());
                String[] arrayString  = ck.getValue().split("split");
                System.err.println(Arrays.toString(arrayString));
                model.addAttribute("arrayString", arrayString);
                break;
            } else {
                ck.setValue("");
                model.addAttribute("cookieCart",ck.getValue());
            }
        }
        return "cart/cart";
    }

    @PostMapping("/cart/remove")
    public String removeProductFromCart(@RequestParam Integer id,
                                        @ModelAttribute("cart") Cart cart){
        cart.removeProduct(this.productService.findById(id));
        return "redirect:/cart";
    }



}
