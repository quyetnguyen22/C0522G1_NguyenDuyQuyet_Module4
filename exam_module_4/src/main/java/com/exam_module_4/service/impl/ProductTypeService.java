package com.exam_module_4.service.impl;

import com.exam_module_4.model.ProductType;
import com.exam_module_4.repository.IProductTypeRepository;
import com.exam_module_4.service.IProductTypeService;
import com.exam_module_4.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {

    @Autowired
    private IProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> getProductType() {
        return productTypeRepository.findAll();
    }
}
