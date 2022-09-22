package com.example.blogvn.repository;

import com.example.blogvn.dto.BlogDto;
import com.example.blogvn.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Blog findById(int id);

    @Query(value = "select * from Blog where title like %:elementSearch%", nativeQuery = true)
    Page<Blog> findBlogByName(Pageable pageable, @Param("elementSearch") String name);

    @Query(value = "select * from Blog where category = :categoryId",nativeQuery = true)
    Page<Blog> findBlogByCategoryId(Pageable pageable, @Param("categoryId") int id);

    @Query(value = "select b.title, c.category_name as categoryName from blog as b join category as c on b.category=c.id", nativeQuery = true,
            countQuery = "select count(*) from (select b.title, c.category_name as categoryName from blog as b join category as c on b.category=c.id) temp")
    Page<BlogDto> findBlogDto(Pageable pageable);

}
