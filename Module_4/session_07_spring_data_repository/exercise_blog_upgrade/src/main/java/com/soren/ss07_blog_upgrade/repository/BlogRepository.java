package com.soren.ss07_blog_upgrade.repository;

import com.soren.ss07_blog_upgrade.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
