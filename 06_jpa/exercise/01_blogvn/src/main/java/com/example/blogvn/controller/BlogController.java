package com.example.blogvn.controller;

import com.example.blogvn.model.Blog;
import com.example.blogvn.service.IBlogService;
import com.example.blogvn.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/home")
    public String home() {
        return "header";
    }



    @GetMapping("/listPage")
    public String showBlogPage(@RequestParam(value = "input", defaultValue = "" ) String input, @PageableDefault(size = 2, sort = "date",
            direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        model.addAttribute("list", blogService.showBlogList(pageable, input));
        model.addAttribute("search", input);
        return "list";
    }

    @GetMapping("/listPage/{id}")
    public String showBlogByCategory(@PathVariable int id, @PageableDefault(value = 2, sort = "date",
            direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        model.addAttribute("list", blogService.showBlogByCategory(pageable, id));
        return "list";
    }

    @GetMapping("/formAdd")
    public String getFormAdd(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", categoryService.categoryList());
        return "add";
    }

    @GetMapping("/saveWriting")
    public String saveWriting(@ModelAttribute Blog blog, RedirectAttributes attributes) {
        blogService.writeNewBlog(blog);
        attributes.addFlashAttribute("msgAdd", "Add " + blog.getTitle() + " successfully");
        return "redirect:/listPage";
    }

    @GetMapping("/viewBlog/{id}")
    public ModelAndView viewBlog(@PathVariable int id) {
        return new ModelAndView("view", "blog", blogService.readBlog(id));
    }

    @GetMapping("/formEdit/{id}")
    public String getFormEdit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.readBlog(id));
        model.addAttribute("categoryList", categoryService.categoryList());
        return "edit";
    }

    @GetMapping("saveEditing")
    public String saveEditing(@ModelAttribute Blog blog, RedirectAttributes attributes) {
        blogService.editBlog(blog);
        attributes.addFlashAttribute("msgEdit", "Edited " + blog.getTitle() + " successfully");
        return "redirect:/listPage";
    }

    @GetMapping("/deleteBlog/{id}")
    public String deleteBlog(@PathVariable int id, RedirectAttributes attributes) {
        Blog blog = blogService.readBlog(id);
        attributes.addFlashAttribute("msgDelete", "Deleted " + blog.getTitle() + " successfully");
        blogService.deleteBlog(id);
        return "redirect:/listPage";
    }

//    @GetMapping("/searchBlog")
//    public String searchBlog(@PageableDefault(size = 2, sort = "date",
//            direction = Sort.Direction.DESC) Pageable pageable,@RequestParam(value = "input", defaultValue = "") String input, Model model) {
//        model.addAttribute("list", blogService.searchBlog(input, pageable));
//        model.addAttribute("search", input);
//        return "list";
//    }
}
