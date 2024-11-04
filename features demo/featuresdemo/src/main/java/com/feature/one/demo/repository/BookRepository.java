package com.feature.one.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.feature.one.demo.model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByGenre(String genre);

    List<Book> findAllByOrderBySoldDesc();

    List<Book> findByRatingGreaterThanEqual(float rating);

    List<Book> findByPublisher(String publisher);;
}
