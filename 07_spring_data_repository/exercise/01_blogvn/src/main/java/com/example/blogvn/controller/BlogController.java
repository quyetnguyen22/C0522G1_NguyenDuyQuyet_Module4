package com.example.blogvn.controller;

import com.example.blogvn.model.Blog;
import com.example.blogvn.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/blogList")
    public String showBlogList(Model model) {
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
        attributes.addFlashAttribute("msgAdd", "Add " + blog.getTitle() + " successfully");
        return "redirect:/blogList";
    }

    @GetMapping("/viewBlog/{id}")
    public ModelAndView viewBlog(@PathVariable int id) {
        return new ModelAndView("view", "blog", blogService.readBlog(id));
    }

    @GetMapping("/formEdit/{id}")
    public String getFormEdit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.readBlog(id));
        return "edit";
    }

    @GetMapping("saveEditing")
    public String saveEditing(@ModelAttribute Blog blog, RedirectAttributes attributes) {
        blogService.editBlog(blog);
        attributes.addFlashAttribute("msgEdit", "Edited " + blog.getTitle() + " successfully");
        return "redirect:/blogList";
    }

    @GetMapping("/deleteBlog/{id}")
    public String deleteBlog(@PathVariable int id, RedirectAttributes attributes) {
        Blog blog = blogService.readBlog(id);
        attributes.addFlashAttribute("msgDelete", "Deleted " + blog.getTitle() + " successfully");
        blogService.deleteBlog(id);
        return "redirect:/blogList";
    }
}
