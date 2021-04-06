package com.soren.ss07_blog_upgrade.service;

import com.soren.ss07_blog_upgrade.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {

    Page<Blog> findAll(Pageable pageable);

    Blog findById(Integer id);

    void save(Blog blog);

    void deleteById(Integer id);

}
