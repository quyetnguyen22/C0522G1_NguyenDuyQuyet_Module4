package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Integer> {

    @Query(value = "select * from Product where product_name like %:inputName%", nativeQuery = true)
    List<Product> findByProductNameContaining(@Param("inputName") String name);

    Product findById(int id);

//    @Query(value = "update Product set productName =:n, productPrice =:p, productDetail =:d, producer =:c where id =:i")
//    void editProduct(@Param("n") )
}
