package com.example.books.Book;

import com.example.books.Author.author;
import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public interface bookRepository extends JpaRepository<book, String>{

}
/*
@Repository
public class bookRepository  {
    private List<book> Books = new ArrayList<book>();

    public List<book> getBooks() {
        return Books;
    }

    @PostConstruct
    private void init(){
        Books.add(new book("title", "author","name", "123456", "descrip", "genre", "publisher", 1995, 20.00));
    }

    Optional<book> getBook(String ISBN){
        String bISBN;
       return Books.stream().filter(book -> book.getISBN()==ISBN).findFirst();
    }

    void addBook(book b){
        Books.add(b);
    }
}
*/