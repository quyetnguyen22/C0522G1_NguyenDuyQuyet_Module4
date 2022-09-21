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

    //    @Override
//    public List<Category> categoryList() {
//        return categoryRepository.findAll();
//    }

    @Autowired
    public List<Category> categoryList() {
        return categoryRepository.showAll();
    }

    @Override
    public Category addNewCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findCategory(int id) {
        return categoryRepository.findById(id);
    }

//    @Override
//    public void deleteCategory(int id) {
//        categoryRepository.deleteById(id);
//    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteCategory(id);
    }

    @Override
    public Category editCategory(Category category) {
        return categoryRepository.save(category);
    }

}
