package com.example.product.service;

import com.example.product.model.Product;

import java.util.List;

public interface IProductService {
    //    Hiển thị danh sách sản phẩm
    List<Product> productList();

    //    Tạo sản phẩm mới
    void addNewProduct(Product product);

    //    Cập nhật thông tin sản phẩm
    void editProduct(Product product);

    //    Xoá một sản phẩm
    void deleteProduct(int id);

    //    Xem chi tiết một sản phẩm
    Product showDetail(int id);

    //    Tìm kiếm sản phẩm theo tên
    List<Product> searchProduct(String input);
}
