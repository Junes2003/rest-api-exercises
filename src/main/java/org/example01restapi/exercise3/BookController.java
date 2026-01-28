package org.example01restapi.exercise3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final List<Book> books = new ArrayList<>();
    private final AtomicInteger idGenerator = new AtomicInteger(3);


    public BookController() {
        Author bloch = new Author(101, "Joshua Bloch", 1961, "American");
        Author martin = new Author(102, "Robert C. Martin", 1952, "American");
        Author fowler = new Author(103, "Martin Fowler", 1963, "British");

        Publisher aw = new Publisher("Addison-Wesley", "USA", 1942);
        Publisher prentice = new Publisher("Prentice Hall", "USA", 1913);

        books.add(new Book(
                1,
                "Effective Java",
                "978-0-13-468599-1",
                2018,
                3,
                bloch,
                aw
        ));

        books.add(new Book(
                2,
                "Clean Code",
                "978-0-13-235088-4",
                2008,
                1,
                martin,
                prentice
        ));

        books.add(new Book(
                3,
                "Refactoring",
                "978-0-201-48567-7",
                2018,
                2,
                fowler,
                aw
        ));
    }

    //localhost:8080/api/books
    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    //localhost:8080/api/books/1
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //localhost:8080/api/books
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        int newId = idGenerator.incrementAndGet();
        book.setId(newId);
        books.add(book);

        return ResponseEntity.created(URI.create("/spi/books/" + book.getId())).body(book);
    }

    //localhost:8080/api/books/1
    @PutMapping
    public ResponseEntity<Book> updateBook(@PathVariable int id,
                                           @RequestBody Book updatedBook) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.setTitle(updatedBook.getTitle());
                book.setIsbn(updatedBook.getIsbn());
                book.setPublishedYear(updatedBook.getPublishedYear());
                book.setEdition(updatedBook.getEdition());
                book.setAuthor(updatedBook.getAuthor());
                book.setPublisher(updatedBook.getPublisher());

                return ResponseEntity.ok(book);
            }
        }
        return ResponseEntity.notFound().build();
    }
    //localhost:8080/api/books/1
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {

        return ResponseEntity.noContent().build();
    }






}
