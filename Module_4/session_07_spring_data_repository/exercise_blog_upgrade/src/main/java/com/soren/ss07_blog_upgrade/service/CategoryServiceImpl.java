package com.soren.ss07_blog_upgrade.service;

import com.soren.ss07_blog_upgrade.model.Category;
import com.soren.ss07_blog_upgrade.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository repository;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }
}
