package com.soren.ss07_blog_upgrade.repository;

import com.soren.ss07_blog_upgrade.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByTitleContaining(String search, Pageable pageable);
    List<Blog> findAllByCategoryId(Integer id);
}
