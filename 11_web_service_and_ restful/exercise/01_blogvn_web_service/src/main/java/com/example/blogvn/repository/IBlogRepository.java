package com.example.blogvn.repository;

import com.example.blogvn.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Blog findById(int id);

    @Query(value = "select * from Blog where category = :categoryId", nativeQuery = true)
    List<Blog> findBlogByCategoryId(@Param("categoryId") int id);

}
