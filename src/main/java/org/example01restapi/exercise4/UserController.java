package org.example01restapi.exercise4;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final List<User> users = new ArrayList<>();
    private static final AtomicLong idGenerator = new AtomicLong(2);

    // Sample data
    static {
        users.add(new User(
                1L,
                "John Doe",
                "jd@ek.dk",
                new Address("Guldbergsgade 29", "Copenhagen", "2200")
        ));

        users.add(new User(
                2L,
                "Jane Smith",
                "js@ek.dk",
                new Address("Amagerbrogade 100", "Copenhagen", "2300")
        ));
    }


    // Exercise 1 + 2: GET all users
    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }


    // Exercise 1 + 2: GET user by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.notFound().build();
    }


    // Exercise 4.1: POST user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        long newId = idGenerator.incrementAndGet();
        user.setId(newId);
        users.add(user);

        return ResponseEntity
                .created(URI.create("/api/users/" + newId))
                .body(user);
    }

    // Exercise 4.2: PUT user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable Long id,
            @RequestBody User updatedUser) {

        for (User user : users) {
            if (user.getId().equals(id)) {
                user.setName(updatedUser.getName());
                user.setEmail(updatedUser.getEmail());
                user.setAddress(updatedUser.getAddress());
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.notFound().build();
    }

    // Exercise 4.3: DELETE user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        users.removeIf(user -> user.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
}
