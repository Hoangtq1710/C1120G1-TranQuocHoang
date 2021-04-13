package com.soren.repository;

import com.soren.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByTitleContaining(String search);

    List<Blog> findAllByCategoryId(Integer id);



}
