package com.example.blogvn.service;

import com.example.blogvn.model.Blog;

import java.util.List;

public interface IBlogService {

    //    Hiển thị danh sách tóm tắt các blog
    List<Blog> showBlogByCategory(int id);

    //    Xem nội dung một blog
    Blog readBlog(int id);

    List<Blog> findAllBlog();
}
