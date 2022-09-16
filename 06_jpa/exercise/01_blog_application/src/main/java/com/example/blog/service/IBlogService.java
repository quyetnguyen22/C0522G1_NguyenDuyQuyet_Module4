package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    //    Viết một bài blog mới
    void writeNewBlog(Blog blog);

    //    Hiển thị danh sách tóm tắt các blog
    List<Blog> showBlogList();

    //    Cập nhật nội dung một blog
    void editBlog(Blog blog);

    //    Xem nội dung một blog
    Optional<Blog> readBlog(int id);

    //    Xoá một blog
    void deleteBlog(int id);
}
