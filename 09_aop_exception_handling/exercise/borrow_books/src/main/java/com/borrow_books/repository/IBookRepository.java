package com.borrow_books.repository;

import com.borrow_books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
    Book findById(int id);

    Book findByBookCode(int code);
}
