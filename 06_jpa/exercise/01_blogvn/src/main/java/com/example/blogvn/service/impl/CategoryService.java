package com.example.blogvn.service.impl;

import com.example.blogvn.model.Category;
import com.example.blogvn.repository.ICategoryRepository;
import com.example.blogvn.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> categoryList() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addNewCategory(Category category) {
       return categoryRepository.save(category);
    }

}
