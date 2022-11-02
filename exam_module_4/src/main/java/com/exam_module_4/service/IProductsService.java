package com.exam_module_4.service;

import com.exam_module_4.model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductsService {

    Page<Products> showAll(Pageable pageable);

    void addNewProduct(Products products);

    Page<Products> searchProduct(Pageable pageable, String search);
}
