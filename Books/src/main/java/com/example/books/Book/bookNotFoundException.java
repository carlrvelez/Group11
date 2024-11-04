package com.example.books.Book;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class bookNotFoundException extends RuntimeException{
    public bookNotFoundException(){
        super("Book not found.");
    }
}
