package com.soren.service;

import com.soren.model.Blog;
import com.soren.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    BlogRepository repository;

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Blog> findAllLoad(Integer start, Integer limit) {
        return repository.findAllLoad(start, limit);
    }

    @Override
    public Blog findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() == null){
            blog.setPostDay(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
        repository.save(blog);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Blog> findAllByTitleContaining(String search) {
        return repository.findAllByTitleContaining(search);
    }

    @Override
    public List<Blog> findAllByCategoryId(Integer id) {
        return repository.findAllByCategoryId(id);
    }

    @Override
    public List<Blog> findNext(int currentIndex) {
        return repository.findNext(currentIndex);
    }

}
