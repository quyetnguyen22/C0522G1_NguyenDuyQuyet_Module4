package com.example.blogvn.service.impl;

import com.example.blogvn.model.Blog;
import com.example.blogvn.repository.IBlogRepository;
import com.example.blogvn.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> showBlogByCategory(int id) {
        return blogRepository.findBlogByCategoryId(id);
    }

    @Override
    public Blog readBlog(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public List<Blog> findAllBlog(String search) {
        return blogRepository.findAll(search);
    }

}
