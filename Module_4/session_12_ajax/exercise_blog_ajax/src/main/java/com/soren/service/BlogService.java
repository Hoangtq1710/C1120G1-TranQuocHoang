package com.soren.service;

import com.soren.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {

    Page<Blog> findAll(Pageable pageable);

    Blog findById(Integer id);

    void save(Blog blog);

    void deleteById(Integer id);

    Page<Blog> findAllByTitleContaining(String search, Pageable pageable);

    List<Blog> findAllByCategoryId(Integer id);
}
