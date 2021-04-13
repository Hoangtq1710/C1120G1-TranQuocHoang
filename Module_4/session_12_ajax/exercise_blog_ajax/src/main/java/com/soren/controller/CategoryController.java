package com.soren.controller;

import com.soren.model.Category;
import com.soren.service.BlogService;
import com.soren.service.CategoryService;
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
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    BlogService blogService;

    @GetMapping("")
    public String getCategoryHome(Model model){
        List<Category> listCategory = this.categoryService.findAll();
        Category category = new Category();
        model.addAttribute("category", category);
        model.addAttribute("listCategory", listCategory);
        return "category_home";
    }

    @PostMapping("/create")
    public String createCategory(Category category, RedirectAttributes redirect){
        this.categoryService.save(category);
        redirect.addFlashAttribute("message", "Category "+category.getName()+" was added");
        return "redirect:/category/";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam Integer id, Model model){
        Category category = this.categoryService.findById(id);
        model.addAttribute("listCategory", this.categoryService.findAll());
        model.addAttribute("category", category);
        return "category/edit";
    }

    @PostMapping("edit")
    public String editCategory(Category category, RedirectAttributes redirect){
        this.categoryService.save(category);
        redirect.addFlashAttribute("message", "Category "+category.getName()+" was updated");
        return "redirect:/category/";
    }

    @PostMapping("/delete")
    public String deleteCategory(@RequestParam Integer id, RedirectAttributes redirect){
        this.categoryService.deleteById(id);
        redirect.addFlashAttribute("message", "Category "+id+" was deleted");
        return "redirect:/category/";
    }

    @GetMapping("/show_blog_of_category")
    public String showBlogOfCategory(@RequestParam Integer id, Model model){
        model.addAttribute("category", this.categoryService.findById(id));
        model.addAttribute("listBlog",this.blogService.findAllByCategoryId(id));
        return "category/show_blog";
    }
}
