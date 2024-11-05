package com.example.books.Book;

//import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.List;

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
      /*  for(int i =0; i<b.size(); i++){
            b.get(i).toString();
        }*/
        return b;
    }

    @GetMapping("/findBook/{id}")
    public book getBook(@PathVariable String id){
       // book b = bookRepository.findById(id).get();
        Optional<book> b = bookRepository.findById(id);
        if(b.isEmpty()){
            throw new bookNotFoundException();
        }
        return b.get();//b.get();//bookRepository.getBook(ISBN);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addBook")
    public book addBook(@RequestBody book b){
       // bookRepository.addBook(b);
        return bookRepository.save(b);
    }

   /*void addBook(book b){//String title, String author, String ISBN, String descrip, String gen, String pub, int year, double price){
        //book b = new book(title, author, ISBN, descrip, gen, pub, year, price);
        Books.add(b);
    }

    @GetMapping("/api/getBook")
    book getBook(String ISBN){
        String bISBN;
        for(int i = 0; i<Books.length(); i++){
            bISBN = getISBN(Books(i));
            if(bISBN == ISBN){
                return Books(i);
            }
        }
        return null;
    }*/


}
