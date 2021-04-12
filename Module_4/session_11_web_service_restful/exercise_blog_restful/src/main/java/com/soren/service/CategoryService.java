package com.soren.service;

import com.soren.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Integer id);

    void save(Category category);

    void deleteById(Integer id);
}
