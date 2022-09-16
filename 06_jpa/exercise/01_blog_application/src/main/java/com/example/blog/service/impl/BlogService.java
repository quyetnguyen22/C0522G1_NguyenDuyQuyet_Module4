package com.example.blog.service.impl;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public void writeNewBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> showBlogList() {
        return blogRepository.findAll();
    }

    @Override
    public void editBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Optional<Blog> readBlog(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void deleteBlog(int id) {
        blogRepository.deleteById(id);
    }
}
