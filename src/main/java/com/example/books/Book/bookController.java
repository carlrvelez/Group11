package com.example.books.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/book")
public class bookController {

    private final bookRepository bookRepository;

    public bookController(bookRepository bookRepository){this.bookRepository = bookRepository;}

    @GetMapping("/hello")
    String greeting(){
        return "Hello World!";
    }

    @GetMapping("/all")
    public List<book> getAllBooks(){
        List<book> b;
        b = bookRepository.findAll();
        return b;
    }

    @GetMapping("/findBook/{id}")
    public book getBook(@PathVariable String id){
        Optional<book> b = bookRepository.findById(id);
        if(b.isEmpty()){
            throw new bookNotFoundException();
        }
        return b.get();
    }

    @GetMapping("/findBooksByAuthor/{id}")
    public List<book> getAuthoredBooks(@PathVariable String id){
        List<book> b = getAllBooks();
        List<book> authoredBooks = new ArrayList<book>();
        String name = id;

        for(int i = 0; i<b.size(); i++) {
            String bookName = b.get(i).getAuthorsLastName();
            if (bookName.equalsIgnoreCase(name)) {
                authoredBooks.add(b.get(i));
            }
        }
        return authoredBooks;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addBook")
    public book addBook(@RequestBody book b){
        return bookRepository.save(b);
    }
}
