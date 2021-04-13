package com.soren.controller;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.databind.JsonNode;
import com.soren.model.Blog;
import com.soren.model.Category;
import com.soren.service.BlogService;
import com.soren.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"/admin"})
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public String getHomeAdmin(Model model){
        List<Blog> listBlog = this.blogService.findAll();
        List<Category> listCategory = this.categoryService.findAll();
        model.addAttribute("listBlog", listBlog);
        model.addAttribute("listCategory", listCategory);
        model.addAttribute("blog", new Blog());
        return "admin";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("listCategory", this.categoryService.findAll());
        return "blog/create";
    }

    @PostMapping("/create")
    public String createArticle(Blog blog, RedirectAttributes redirect){
        this.blogService.save(blog);
        redirect.addFlashAttribute("message", "Blog "+blog.getId()+" was added");
        return "redirect:/admin/";
    }

    @GetMapping("/view")
    public String viewArticle(@RequestParam Integer id,Model model){
        Blog blog = this.blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/view";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam Integer id, Model model){
        Blog blog = this.blogService.findById(id);
        List<Category> listCategory = this.categoryService.findAll();
        model.addAttribute("listCategory", listCategory);
        model.addAttribute("blog", blog);
        return "blog/edit";
    }

    @PostMapping("/edit")
    public String editBlog(Blog blog, RedirectAttributes redirect){
        this.blogService.save(blog);
        redirect.addFlashAttribute("message", "Blog "+blog.getId()+" was updated");
        return "redirect:/admin/";
    }

    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam Integer id, Model model){
        Blog blog = this.blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/delete";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam Integer id, RedirectAttributes redirect){
        this.blogService.deleteById(id);
        redirect.addFlashAttribute("message", "Blog "+id+" was deleted");
        return "redirect:/admin/";
    }

    @GetMapping("/search")
    public String searchByTitle(@RequestParam Optional<String> search,Model model){
        List<Blog> listBlog;
        if (search.isPresent()){
            listBlog = this.blogService.findAllByTitleContaining(search.get());
            model.addAttribute("search", search.get());
        } else {
            listBlog = this.blogService.findAll();
        }
        model.addAttribute("listBlog", listBlog);

        List<Category> listCategory = this.categoryService.findAll();

        model.addAttribute("blog", new Blog());
        model.addAttribute("listCategory", listCategory);
        return "admin";
    }

    @GetMapping("/load")
    public Blog loadMore(){
        return this.blogService.findById(2);
    }

}
