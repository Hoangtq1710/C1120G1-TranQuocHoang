package com.soren.ss07_blog_upgrade.controller;

import com.soren.ss07_blog_upgrade.model.Blog;
import com.soren.ss07_blog_upgrade.model.Category;
import com.soren.ss07_blog_upgrade.service.BlogService;
import com.soren.ss07_blog_upgrade.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String getHomeAdmin(Model model,
                               @PageableDefault(value = 5) Pageable pageable){
        Page<Blog> listBlog = this.blogService.findAll(pageable);
        List<Category> listCategory = this.categoryService.findAll();
        model.addAttribute("listBlog", listBlog);
        model.addAttribute("listCategory", listCategory);
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
    public String showEditForm(@RequestParam Integer id, Model model,
                               @PageableDefault(value = 3) Pageable pageable){
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

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam Integer id, RedirectAttributes redirect){
        this.blogService.deleteById(id);
        redirect.addFlashAttribute("message", "Blog "+id+" was deleted");
        return "redirect:/admin/";
    }

    @GetMapping("/search")
    public String searchByTitle(@RequestParam Optional<String> search,
                                @PageableDefault(value = 3) Pageable pageable,
                                Model model){
        Page<Blog> listBlog;
        if (search.isPresent()){
            listBlog = this.blogService.findAllByTitleContaining(search.get(), pageable);
            model.addAttribute("search", search.get());
        } else {
            listBlog = this.blogService.findAll(pageable);
        }
        model.addAttribute("listBlog", listBlog);

        List<Category> listCategory = this.categoryService.findAll();

        model.addAttribute("blog", new Blog());
        model.addAttribute("listCategory", listCategory);
        return "admin";
    }
}
