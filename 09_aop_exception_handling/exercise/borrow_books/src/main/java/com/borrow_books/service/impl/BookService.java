package com.borrow_books.service.impl;

import com.borrow_books.model.Book;
import com.borrow_books.repository.IBookRepository;
import com.borrow_books.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    public Book borrowBook(Book book) {
        book.setQuantity(book.getQuantity() - 1);
        return bookRepository.save(book);
    }

    public Book returnBook(Book book) {
        book.setQuantity(book.getQuantity() + 1);
        return bookRepository.save(book);
    }

    public Page<Book> getList(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    public Book viewBook(int id) {
        return bookRepository.findById(id);
    }

    public Book viewBookByCode(int code) {
        return bookRepository.findByBookCode(code);
    }

}
