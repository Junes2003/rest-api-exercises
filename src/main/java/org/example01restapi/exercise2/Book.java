package org.example01restapi.exercise2;

import org.example01restapi.exercise2.Author;
import org.example01restapi.exercise2.Publisher;

public class Book {

    private int id;
    private String title;
    private String isbn;
    private int publishedYear;
    private int edition;
    private Author author;
    private Publisher publisher;

    public Book(int id, String title, String isbn, int publishedYear,
                int edition, Author author, Publisher publisher) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.edition = edition;
        this.author = author;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
