package org.example01restapi.exercise2;

public class Book {

    private int id;
    private String title;
    private String isbon;
    private int publishedYear;
    private int edition;
    private Author author;
    private Publisher publisher;


    public Book(String title, int id, int edition, String isbon, int publishedYear, Author author, Publisher publisher) {
        this.title = title;
        this.id = id;
        this.edition = edition;
        this.isbon = isbon;
        this.publishedYear = publishedYear;
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

    public String getIsbon() {
        return isbon;
    }

    public void setIsbon(String isbon) {
        this.isbon = isbon;
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
