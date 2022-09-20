package com.example.blogvn.controller;

import com.example.blogvn.model.Blog;
import com.example.blogvn.model.Category;
import com.example.blogvn.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/category")
    public ModelAndView categoryList() {
        return new ModelAndView("category", "categoryList", categoryService.categoryList());
    }

    @GetMapping("/addCategory")
    public String addNewCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addCategory";
    }

    @GetMapping("/saveCategory")
    public String saveCategory(@ModelAttribute Category category, RedirectAttributes attributes) {
        Category category1 = categoryService.addNewCategory(category);
        attributes.addFlashAttribute("msgAddCa", "Add " +
                category1.getCategoryName() + " successfully");
        return "redirect:/category";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable int id, RedirectAttributes attributes) {
        Category category = categoryService.findCategory(id);
        attributes.addFlashAttribute("msgDelete", "Deleted " +
                category.getCategoryName() + " successfully");
        categoryService.deleteCategory(id);
        return "redirect:/category";
    }

    @GetMapping("/editCategory/{id}")
    public String getFormEdit(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findCategory(id));
        return "editCategory";
    }

    @GetMapping("saveEditCategory")
    public String saveEditCategory(@ModelAttribute Category category, RedirectAttributes attributes) {
        categoryService.editCategory(category);
        attributes.addFlashAttribute("msgEdit", "Edited " + category.getCategoryName() + " successfully");
        return "redirect:/listPage";
    }
}
