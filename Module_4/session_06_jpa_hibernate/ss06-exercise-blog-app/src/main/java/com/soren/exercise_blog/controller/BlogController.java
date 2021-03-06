package com.soren.exercise_blog.controller;

import com.soren.exercise_blog.model.Blog;
import com.soren.exercise_blog.service.BlogService;
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
@RequestMapping({"/admin"})
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("")
    public String getHomeAdmin(Model model){
        List<Blog> listBlog = this.blogService.findAll();
        model.addAttribute("listBlog", listBlog);
        model.addAttribute("blog", new Blog());
        return "admin";
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

    @GetMapping("/show_edit")
    public String showEditForm(@RequestParam Integer id, Model model){
        Blog blog = this.blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/edit";
    }

    @PostMapping("/edit")
    public String editBlog(Blog blog, RedirectAttributes redirect){
        this.blogService.save(blog);
        redirect.addFlashAttribute("message", "Information of Blog "+blog.getId()+" was updated");
        return "redirect:/admin/";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam Integer id, RedirectAttributes redirect){
        this.blogService.deleteById(id);
        redirect.addFlashAttribute("message", "Blog "+id+" was deleted");
        return "redirect:/admin/";
    }
}
