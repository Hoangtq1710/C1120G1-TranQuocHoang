package com.soren.ss07_blog_upgrade.service;

import com.soren.ss07_blog_upgrade.model.Blog;
import com.soren.ss07_blog_upgrade.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    BlogRepository repository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return repository.findAll(pageable);
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
