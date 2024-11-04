package com.example.books.Author;
import com.example.books.Book.book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/author")
public class authorController {

    private final authorRepository auRep;

    public authorController(authorRepository authorRep){
        auRep = authorRep;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addAuthor")
    public author addAuthor(@RequestBody author a){
        return auRep.save(a);
    }

    @PostMapping("/addBook/{id}")
    public author addBookToAuthor(@RequestBody book b, @PathVariable Integer id){
      /*  Optional<author> a = auRep.findById(id);
        if(a.isEmpty()){
            throw new authorNotFoundException();
        }*/
        Optional<author> a = Optional.ofNullable(getBooks(id));
        a.get().addBook(b);
        return a.get();
    }

    @GetMapping("/findAuthoredBooks/{id}")
    public author getBooks(@PathVariable Integer id){
        Optional<author> a = auRep.findById(id);
        if(a.isEmpty()){
            throw new authorNotFoundException();
        }
        return a.get();
    }

    @GetMapping("/all")
    public List<author> getAllAuthors(){
        List<author> a = auRep.findAll();
        return a;
    }

    @GetMapping("/hello")
    String greeting(){
        return "Hello World!";
    }
}
