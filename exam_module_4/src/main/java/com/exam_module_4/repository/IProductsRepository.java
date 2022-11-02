package com.exam_module_4.repository;

import com.exam_module_4.model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductsRepository extends JpaRepository<Products, Integer> {

    @Query(value = "select * from products where is_deleted = 0", nativeQuery = true)
    Page<Products> findAll(Pageable pageable);

    @Query(value = "select * from products where name like % :inputValue% and price like % :inputValue% and is_deleted = 0", nativeQuery = true)
    Page<Products> findProduct(Pageable pageable, @Param("inputValue") String search);
}
