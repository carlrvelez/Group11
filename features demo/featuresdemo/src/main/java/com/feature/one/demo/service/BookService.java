package com.feature.one.demo.service;
import com.feature.one.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.feature.one.demo.model.Book;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(Long id) {
        return (Book) bookRepository.findById(id).orElse(null);
    }

    public Book addBook(Book book) {
        return (Book) bookRepository.save(book);
    }


    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }

    public List<Book> findBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    public List<Book> findAllBooksSortedBySoldDesc() {
        return bookRepository.findAllByOrderBySoldDesc();
    }

    public List<Book> findBooksByMinimumRating(float rating) {
        return bookRepository.findByRatingGreaterThanEqual(rating);
    }

    public List<Book> updateBooksPriceByPublisher(String publisher, double discountPercent) {
        List<Book> publisherBooks = bookRepository.findByPublisher(publisher);

        if (!publisherBooks.isEmpty()) {
            publisherBooks.forEach(book -> {
                double currentPrice = book.getPrice();
                double discountAmount = (discountPercent / 100) * currentPrice;
                double newPrice = currentPrice - discountAmount;
                book.setPrice((float) newPrice);
                book.setDiscount((float) discountPercent); // Update the discount field
            });

            return bookRepository.saveAll(publisherBooks);
        }

        return publisherBooks;
    }

}