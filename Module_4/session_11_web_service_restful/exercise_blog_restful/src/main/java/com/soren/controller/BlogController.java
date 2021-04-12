package com.soren.controller;

import com.soren.model.Blog;
import com.soren.model.Category;
import com.soren.service.BlogService;
import com.soren.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getListAllCategory(){
        List<Category> listCategory = this.categoryService.findAll();
        if (listCategory.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listCategory, HttpStatus.OK);
    }

    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> getListAllBlog(){
        List<Blog> listBlog = this.blogService.findAll();
        if (listBlog.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listBlog,HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Blog>> getListBlogByCategoryId(@PathVariable("id") Integer id){
        List<Blog> listBlog = this.blogService.findAllByCategoryId(id);
        if (listBlog.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listBlog, HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> viewBlogDetail(@PathVariable("id") Integer id){
        Blog blog = this.blogService.findById(id);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }




}
