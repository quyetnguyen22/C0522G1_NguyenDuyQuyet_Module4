package com.example.blogvn.repository;

import com.example.blogvn.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Blog findById(int id);
}
