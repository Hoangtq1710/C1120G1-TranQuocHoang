package com.soren.ss07_blog_upgrade.service;

import com.soren.ss07_blog_upgrade.model.Blog;

import java.util.List;

public interface BlogService {

    List<Blog> findAll();

    Blog findById(Integer id);

    void save(Blog blog);

    void deleteById(Integer id);

}
