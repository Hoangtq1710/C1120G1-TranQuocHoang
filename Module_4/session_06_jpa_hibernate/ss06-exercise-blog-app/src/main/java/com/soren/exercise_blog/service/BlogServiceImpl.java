package com.soren.exercise_blog.service;

import com.soren.exercise_blog.model.Blog;
import com.soren.exercise_blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.DateUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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

}
