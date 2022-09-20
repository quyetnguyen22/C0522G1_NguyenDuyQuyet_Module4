package com.example.blogvn.service;

import com.example.blogvn.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> categoryList();

    Category addNewCategory(Category category);
}
