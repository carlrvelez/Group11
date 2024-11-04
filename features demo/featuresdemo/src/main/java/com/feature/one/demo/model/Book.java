package com.feature.one.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Book {
    @Id
    private long id;
    private String title;
    private String genre;
    private String publisher;
    private int sold;
    private float rating;
    private float price;
    private float discount;





    public Book() {
        super();
    }
    public Book(long id, String title, String genre, String publisher, int sold, float rating, float price, float discount) {
        super();
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.publisher = publisher;
        this.sold = sold;
        this.rating = rating;
        this.discount = discount;
        this.price = price;

    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
