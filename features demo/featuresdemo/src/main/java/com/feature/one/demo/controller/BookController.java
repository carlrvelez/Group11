package com.feature.one.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.feature.one.demo.model.Book;

import com.feature.one.demo.service.BookService;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.findAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id) {
        Book book = bookService.findBookById(id);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/books")
    public ResponseEntity<Void> deleteBooks() {
        bookService.deleteAllBooks();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/books/genre/{genre}")
    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable String genre) {
        List<Book> books = bookService.findBooksByGenre(genre);
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/books/bestsellers")
    public ResponseEntity<List<Book>> getBestsellers() {
        List<Book> books = bookService.findAllBooksSortedBySoldDesc();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/books/rating/{minRating}")
    public ResponseEntity<List<Book>> getBooksByMinimumRating(@PathVariable float minRating) {
        if (minRating < 0 || minRating > 10) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Book> books = bookService.findBooksByMinimumRating(minRating);
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PutMapping("/books/publisher/{publisher}/discount")
    public ResponseEntity<Map<String, Object>> updatePublisherBooksPrice(
            @PathVariable String publisher,
            @RequestParam double discountPercent) {

        if (discountPercent < 0 || discountPercent > 100) {
            return new ResponseEntity<>(
                    Map.of("error", "Discount percentage must be between 0 and 100"),
                    HttpStatus.BAD_REQUEST
            );
        }

        List<Book> updatedBooks = bookService.updateBooksPriceByPublisher(publisher, discountPercent);

        if (updatedBooks.isEmpty()) {
            return new ResponseEntity<>(
                    Map.of("message", "No books found for publisher: " + publisher),
                    HttpStatus.NOT_FOUND
            );
        }

        Map<String, Object> response = new HashMap<>();
        response.put("message", String.format("Successfully updated prices for %d books", updatedBooks.size()));
        response.put("publisher", publisher);
        response.put("discountApplied", discountPercent + "%");
        response.put("updatedBooks", updatedBooks);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
