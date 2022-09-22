package com.borrow_books.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle{
    @ExceptionHandler(NullPointerException.class)
    public String showErrors(){
        return "errors";
    }
}
