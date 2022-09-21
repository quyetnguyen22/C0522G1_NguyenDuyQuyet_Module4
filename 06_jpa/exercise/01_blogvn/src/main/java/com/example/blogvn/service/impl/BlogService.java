package com.example.blogvn.service.impl;

import com.example.blogvn.dto.BlogDto;
import com.example.blogvn.model.Blog;
import com.example.blogvn.repository.IBlogRepository;
import com.example.blogvn.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public void writeNewBlog(Blog blog) {
        blogRepository.save(blog);
    }


    @Override
    public Page<Blog> showBlogByCategory(Pageable pageable, int id) {
        return blogRepository.findBlogByCategoryId(pageable, id);
    }

    @Override
    public Page<Blog> showBlogList(Pageable pageable, String input) {
        return blogRepository.findBlogByName(pageable, input);
    }

    @Override
    public void editBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog readBlog(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void deleteBlog(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<BlogDto> findBlogDto(Pageable pageable) {
        return blogRepository.findBlogDto(pageable);
    }

    //    @Override
//    public Page<Blog> searchBlog(String name, Pageable pageable) {
//        return blogRepository.findBlogByName(name, pageable);
//    }

}
