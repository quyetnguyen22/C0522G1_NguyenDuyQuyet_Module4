package com.exam_module_4.service.impl;


import com.exam_module_4.model.Products;
import com.exam_module_4.repository.IProductsRepository;
import com.exam_module_4.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductsService implements IProductsService {

    @Autowired
    private IProductsRepository productsRepository;

    @Override
    public Page<Products> showAll(Pageable pageable) {
        return productsRepository.findAll(pageable);
    }

    @Override
    public void addNewProduct(Products products) {
        productsRepository.save(products);
    }

    @Override
    public Page<Products> searchProduct(Pageable pageable, String search) {
        return productsRepository.findProduct(pageable, search);
    }
}
