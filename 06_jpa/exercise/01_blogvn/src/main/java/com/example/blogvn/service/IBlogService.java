package com.example.blogvn.service;

import com.example.blogvn.model.Blog;

import java.util.List;

public interface IBlogService {
    //    Viết một bài blog mới
    void writeNewBlog(Blog blog);

    //    Hiển thị danh sách tóm tắt các blog
    List<Blog> showBlogList();

    //    Cập nhật nội dung một blog
    void editBlog(Blog blog);

    //    Xem nội dung một blog
    Blog readBlog(int id);

    //    Xoá một blog
    void deleteBlog(int id);
}
