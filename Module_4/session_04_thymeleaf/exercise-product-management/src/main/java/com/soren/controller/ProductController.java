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

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ModelAndView getHome(){
        List<Product> listProduct = this.productService.findAll();
        return new ModelAndView("index","listProduct", listProduct );
    }

    @GetMapping("/showCreate")
    public ModelAndView showCreateForm(){
        return new ModelAndView("create", "product", new Product());
    }

    @PostMapping("/create")
    public ModelAndView createProduct(Product product){
        ModelAndView modelAndView = new ModelAndView();
        if (!this.productService.isExistId(product.getId())){
            this.productService.save(product);
            return getHome();
        } else {
            modelAndView.addObject("message", "ID "+product.getId()+" was existed!");
            modelAndView.setViewName("create");
            return modelAndView;
        }
    }

    @GetMapping("/showEdit")
    public ModelAndView showEditForm(@RequestParam int id){
        Product product = this.productService.findById(id);
        return new ModelAndView("edit", "product",product);
    }

    @PostMapping("/editProduct")
    public ModelAndView editProduct(Product product, ModelAndView modelAndView){
        this.productService.update(product.getId(), product);
        modelAndView.addObject("messageUpdate","Product information was updated");
        return getHome();
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
    public ModelAndView deleteProduct(Product product){
        this.productService.remove(product.getId());
    }
}
