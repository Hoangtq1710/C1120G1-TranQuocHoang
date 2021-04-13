package com.soren.service;

import com.soren.model.Blog;
import java.util.List;

public interface BlogService {

    List<Blog> findAll();

    List<Blog> findAllLoad(Integer start, Integer limit);

    Blog findById(Integer id);

    void save(Blog blog);

    void deleteById(Integer id);

    List<Blog> findAllByTitleContaining(String search);

    List<Blog> findAllByCategoryId(Integer id);

    List<Blog> findNext(int currentIndex);
}
