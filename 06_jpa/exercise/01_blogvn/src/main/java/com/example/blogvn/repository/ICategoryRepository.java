package com.example.blogvn.repository;

import com.example.blogvn.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    Category findById(int id);
}
