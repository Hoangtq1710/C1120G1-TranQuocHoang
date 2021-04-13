package com.soren.repository;

import com.soren.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByTitleContaining(String search);

    List<Blog> findAllByCategoryId(Integer id);

    @Query(value = "select * from blog limit ?1, ?2", nativeQuery = true)
    List<Blog> findAllLoad(int start, int limit);

    @Query(value = "select * from blog limit ?1, 2", nativeQuery = true)
    List<Blog> findNext(int currentIndex);

}
