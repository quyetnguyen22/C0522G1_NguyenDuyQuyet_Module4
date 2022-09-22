package com.borrow_books.model;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String bookName;
    private int quantity;
    private String bookType;
    private int bookCode;
//    private String bookCode = "B-";

    @Column(columnDefinition = "TEXT")
    private String detail;

    public Book() {
    }

    public Book(Integer id, String bookName, int quantity, String bookType, int bookCode, String detail) {
        this.id = id;
        this.bookName = bookName;
        this.quantity = quantity;
        this.bookType = bookType;
        this.bookCode = bookCode;
        this.detail = detail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public int getBookCode() {
        return bookCode;
    }

    public void setBookCode(int bookCode) {
        this.bookCode = bookCode;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
