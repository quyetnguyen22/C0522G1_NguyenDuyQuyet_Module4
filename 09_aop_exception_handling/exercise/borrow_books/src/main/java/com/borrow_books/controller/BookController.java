package com.borrow_books.controller;

import com.borrow_books.model.Book;
import com.borrow_books.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/bookList")
    public String getListBook(@RequestParam(value = "input", defaultValue = "") String input,
                              @PageableDefault(value = 5, sort = "bookName") Pageable pageable, Model model) {
        model.addAttribute("bookList", bookService.getList(pageable));
        model.addAttribute("search", input);
        return "library";
    }

    @GetMapping("/bookDetail/{id}")
    public String borrowBook(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.viewBook(id));
        return "bookDetail";
    }

    @GetMapping("/borrow/{id}")
    public String borrowBooks(@PageableDefault Pageable pageable,
                              @PathVariable int id, Model model,
                              RedirectAttributes attributes){
        Book book = bookService.viewBook(id);
        if (book.getQuantity() == 0) {
            attributes.addFlashAttribute("msgOOS", "Out of stock");
            return "redirect:/bookList";
        } else {
            bookService.borrowBook(book);
            model.addAttribute("bookList", bookService.getList(pageable));
            return "library";
        }
    }

    @GetMapping("/returnBook")
    public String returnBook() {
        return "return";
    }

    @GetMapping("/return")
    public String returnBooks(@PageableDefault Pageable pageable,
                              @RequestParam int code, Model model) {
        Book book = bookService.viewBookByCode(code);
        if (book == null) {
            throw new NullPointerException();
        } else {
            bookService.returnBook(book);
            model.addAttribute("bookList", bookService.getList(pageable));
            return "library";
        }
    }

}
