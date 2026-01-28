package org.example01restapi.exercise2;

import org.example01restapi.exercise2.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final List<Book> books = new ArrayList<>();

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

    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
