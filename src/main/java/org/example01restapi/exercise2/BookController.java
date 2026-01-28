package org.example01restapi.exercise2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final List<Book> books = new ArrayList<>();

    public BookController() {
        Author block = new Author(101, "Joshua Bloch", "American", 1961);
        Author martin = new Author(102, "Robert C. Martin", "American", 1952);
        Author fowler = new Author(103, "Martin Fowler", "British", 1963);

        Publisher aw = new Publisher("Addison-Wesley", "USA", 1942);
        Publisher prentice = new Publisher("Prentice Hall", "USA", 1913);

        books.add(new Book(
                "Effective Java",
                1,
                "978-0-13-468599-1",
                2018,
                3,
                "bloch",
                "aw"
        ));

    }
}
