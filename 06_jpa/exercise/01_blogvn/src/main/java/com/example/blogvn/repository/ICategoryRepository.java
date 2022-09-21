package com.example.blogvn.repository;

import com.example.blogvn.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    Category findById(int id);

    @Query(value = "update category set is_deleted = 1 where id = :id", nativeQuery = true)
    void deleteCategory(@Param("id") int id);

    @Query(value = "select * from category where is_deleted = 0", nativeQuery = true)
    List<Category> showAll();
}
