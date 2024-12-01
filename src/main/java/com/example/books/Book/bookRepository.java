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
