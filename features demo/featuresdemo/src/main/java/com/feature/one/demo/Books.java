package com.feature.one.demo;

import jakarta.persistence.*;

@Entity
@Table (name = "BookSelection")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    @Column
    private String title;
    @Column
    private String genre;
    @Column
    private double rating;
    @Column
    private String publisher;
    @Column
    private float discount;

    public Books(){

    }

    public Books(String title, String genre, double rating, String publisher, float discount) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.publisher = publisher;
        this.discount = discount;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", publisher='" + publisher + '\'' +
                ", discount=" + discount +
                '}';
    }
}
