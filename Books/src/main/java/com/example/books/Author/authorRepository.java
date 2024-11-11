package com.example.books.Author;

import com.example.books.Book.book;
import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface authorRepository extends JpaRepository<author, Integer>{

}
/*public class authorRepository extends JpaRepository<author, Long> {

    private List<author> Authors = new ArrayList<author>();

   void addAuthor(author a){
       Authors.add(a);
   }

    @PostConstruct
    private void init(){
        Authors.add(new author("first", "last", "pub", "bio"));
    }
}
*/