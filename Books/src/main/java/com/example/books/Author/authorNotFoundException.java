package com.example.books.Author;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class authorNotFoundException extends RuntimeException {
    public authorNotFoundException(){
        super("Author not found.");
    }
}
