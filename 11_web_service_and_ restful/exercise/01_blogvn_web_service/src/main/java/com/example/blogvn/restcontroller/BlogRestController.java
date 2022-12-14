package com.example.blogvn.restcontroller;

import com.example.blogvn.model.Blog;
import com.example.blogvn.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blogList/v1")
public class BlogRestController {

    @Autowired
    private IBlogService blogService;

    @GetMapping()
    public ResponseEntity<List<Blog>> getBlogList() {

        List<Blog> blogList = blogService.findAllBlog();

        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Blog>> getBlogByCategory(@PathVariable int id) {

        List<Blog> blogListByCategory = blogService.showBlogByCategory(id);

        if (blogListByCategory.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogListByCategory, HttpStatus.OK);
        }
    }

    @GetMapping("blogDetail/{id}")
    public ResponseEntity<Blog> getBlogDetail(@PathVariable int id) {

        Blog blogDetail = blogService.readBlog(id);

        if (blogDetail == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogDetail, HttpStatus.OK);
        }
    }
}
