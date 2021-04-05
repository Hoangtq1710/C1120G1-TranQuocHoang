package com.soren.exercise_blog.service;

import com.soren.exercise_blog.model.Blog;

import java.util.List;

public interface BlogService {

    List<Blog> findAll();

    Blog findById(Integer id);

    void save(Blog blog);

    void deleteById(Integer id);

    String getPostTime();

}
