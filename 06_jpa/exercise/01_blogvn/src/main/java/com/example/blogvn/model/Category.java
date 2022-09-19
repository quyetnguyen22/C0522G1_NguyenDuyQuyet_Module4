package com.example.blogvn.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Blog> blog;

    public Category() {
    }

    public Category(Integer id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Blog> getBlog() {
        return blog;
    }

    public void setBlog(List<Blog> blog) {
        this.blog = blog;
    }
}
