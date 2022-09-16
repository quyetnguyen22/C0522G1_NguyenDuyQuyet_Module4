package product.manager.service;

import product.manager.model.Product;

import java.util.List;

public interface IProductService {
    //    Hiển thị danh sách sản phẩm
    List<Product> productList();

    //    Tạo sản phẩm mới
    boolean addNewProduct(Product product);

    //    Cập nhật thông tin sản phẩm
    boolean editProduct(Product product);

    //    Xoá một sản phẩm
    boolean deleteProduct(int id);

    //    Xem chi tiết một sản phẩm
    Product showDetail(int id);

    //    Tìm kiếm sản phẩm theo tên
    List<Product> searchProduct(String name);
}
