package com.example.blogvn.service;

import com.example.blogvn.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    //    Viết một bài blog mới
    void writeNewBlog(Blog blog);

    //    Hiển thị danh sách tóm tắt các blog
    Page<Blog> showBlogByCategory(Pageable pageable, int id);

    Page<Blog> showBlogList(Pageable pageable, String input);

    //    Cập nhật nội dung một blog
    void editBlog(Blog blog);

    //    Xem nội dung một blog
    Blog readBlog(int id);

    //    Xoá một blog
    void deleteBlog(int id);

//    Page<Blog> searchBlog(String name, Pageable pageable);
}
