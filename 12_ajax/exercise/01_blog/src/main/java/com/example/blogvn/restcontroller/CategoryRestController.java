package com.example.blogvn.restcontroller;

import com.example.blogvn.model.Category;
import com.example.blogvn.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categoryList/v1")
public class CategoryRestController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<Category>> getCategoryList() {

        List<Category> categoryList = categoryService.categoryList();

        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(categoryList, HttpStatus.OK);
        }
    }

}
