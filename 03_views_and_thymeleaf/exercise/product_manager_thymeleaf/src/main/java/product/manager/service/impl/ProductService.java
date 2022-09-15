package product.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.manager.model.Product;
import product.manager.repository.IProductRepository;
import product.manager.service.IProductService;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> productList() {
        return productRepository.productList();
    }

    @Override
    public boolean addNewProduct(Product product) {
        return productRepository.addNewProduct(product);
    }

    @Override
    public boolean editProduct(Product product) {
        return productRepository.editProduct(product);
    }

    @Override
    public boolean deleteProduct(int id) {
        return productRepository.deleteProduct(id);
    }

    @Override
    public Product showDetail(int id) {
        return productRepository.showDetail(id);
    }

    @Override
    public List<Product> searchProduct(String name) {
        return productRepository.searchProduct(name);
    }
}
