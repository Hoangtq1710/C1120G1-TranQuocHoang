package com.soren.ss07_blog_upgrade.repository;

import com.soren.ss07_blog_upgrade.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
