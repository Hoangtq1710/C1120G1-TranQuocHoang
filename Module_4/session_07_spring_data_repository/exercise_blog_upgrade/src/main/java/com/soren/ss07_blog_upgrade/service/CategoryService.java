package com.soren.ss07_blog_upgrade.service;

import com.soren.ss07_blog_upgrade.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Integer id);

    void save(Category category);

    void deleteById(Integer id);
}
