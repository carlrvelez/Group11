package com.example.books.Author;
import java.util.List;
import java.util.ArrayList;

import com.example.books.Book.book;
import jakarta.persistence.*;

//import javax.persistence.*;

@Entity
@Table(name = "authors")
public class author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorID;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String biography;
    @Column
    private String publisher;

   @OneToMany
    @JoinColumn(name = "books")
    private List<book> authoredBooks;

    //List of ISBN's that can then get a list of books?
    //private List<String> authoredBooks = new ArrayList<String>();

    public author(String first, String last, String pub, String bio){

        firstName = first;
        lastName = last;
        publisher = pub;
        biography = bio;
    }

    public author() {

    }

   /* List<String> getAuthoredBooks(){
        return authoredBooks;
    }*/

    public int getAuthorID() {
        return authorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getBiography() {
        return biography;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

   public void setAuthoredBooks(List<book> authoredBooks) {
        this.authoredBooks = authoredBooks;
    }

    public void addBook(book b){
        authoredBooks.add(b);
    }

    public List<book> getAuthoredBooks() {
        return authoredBooks;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "author{" +
                "authorID=" + authorID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", biography='" + biography + '\'' +
                ", publisher='" + publisher + '\'' +
                ", authoredBooks=" + authoredBooks +
                '}';
    }
}
