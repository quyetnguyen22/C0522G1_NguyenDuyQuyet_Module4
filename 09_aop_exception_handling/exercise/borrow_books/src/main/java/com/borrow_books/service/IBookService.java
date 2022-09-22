package com.borrow_books.service;

import com.borrow_books.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {

    Book borrowBook(Book book);

    Book returnBook(Book book);

    Page<Book> getList(Pageable pageable);

    Book viewBook(int id);

    Book viewBookByCode(int code);
}
