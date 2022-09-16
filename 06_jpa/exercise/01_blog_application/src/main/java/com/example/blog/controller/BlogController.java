package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/blogList")
    public String getBlogList(Model model) {
        model.addAttribute("list",blogService.showBlogList());
        return "list";
    }

    @GetMapping("/formAdd")
    public String getFormAdd(Model model) {
        model.addAttribute("blog", new Blog());
        return "add";
    }

    @GetMapping("/saveWriting")
    public String saveWriting(@ModelAttribute Blog blog, RedirectAttributes attributes) {
        blogService.writeNewBlog(blog);
        attributes.addFlashAttribute("msgAdd", "Add" + blog.getTitle() + "successfully");
        return "redirect:/blogList";
    }
}
