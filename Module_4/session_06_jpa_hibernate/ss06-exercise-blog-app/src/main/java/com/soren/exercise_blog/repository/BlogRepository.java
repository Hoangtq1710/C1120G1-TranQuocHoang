package com.soren.exercise_blog.repository;

import com.soren.exercise_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
