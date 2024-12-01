package com.example.books.Book;

import com.example.books.Author.author;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;


@Entity
@Table(name = "books")
public class book {
    @Column
    private String title;
    @Column
    private String authorsFirstName;
    @Column
    private String authorsLastName;

    @Id
    //@JsonProperty
    private String ISBN;
    @Column
    private String description;
    @Column
    private String genre;
    @Column
    private String publisher;
    @Column
    private int yearPublished;
    @Column
    private int copiesSold;
    @Column
    private double price;




    public book(String title, String authorFirst, String authorLast, String ISBN, String descrip, String gen, String pub, int year, double price){
        this.title = title;
        authorsFirstName = authorFirst;
        authorsLastName = authorLast;

        this.ISBN = ISBN;
        description = descrip;
        genre = gen;
        publisher = pub;
        yearPublished = year;
        copiesSold = 0;
        this.price = price;

    }

    public book() {

    }

    public String getISBN(){
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorsLastName() {
        return authorsLastName;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthorsFirstName(){
        return authorsFirstName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorsFirstName(String authorsFirstName) {
        this.authorsFirstName = authorsFirstName;
    }

    public void setAuthorsLastName(String authorsLastName) {
        this.authorsLastName = authorsLastName;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "book{" +
                "title='" + title + '\'' +
                ", authorsFirstName='" + authorsFirstName + '\'' +
                ", authorsLastName='" + authorsLastName + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' +
                ", yearPublished=" + yearPublished +
                ", copiesSold=" + copiesSold +
                ", price=" + price +
                '}';
    }
}
