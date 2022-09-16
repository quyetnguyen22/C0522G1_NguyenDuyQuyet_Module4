package com.example.product.service.impl;

import com.example.product.model.Product;
import com.example.product.repository.IProductRepository;
import com.example.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> productList() {
        return productRepository.findAll();
    }

    @Override
    public void addNewProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void editProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product showDetail(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> searchProduct(String input) {
        return productRepository.findByProductNameContaining(input);
    }
}
