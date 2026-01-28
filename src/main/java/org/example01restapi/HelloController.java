package org.example01restapi;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public GreetingResponse hello() {
        return new GreetingResponse(
                "Hello, World!",
                LocalDateTime.now()
        );
    }

    @GetMapping("/api/greet/{name}")
    public GreetingResponse greet(@PathVariable String name) {
        return new GreetingResponse(
                "Hello, " + name + "!",
                LocalDateTime.now()
        );
    }

    @GetMapping("/api/echo")
    public Map<String, Object> echo(@RequestParam String text) {
        Map<String, Object> response = new HashMap<>();
        response.put("echo", text);
        response.put("timestamp", LocalDateTime.now());
        return response;
    }
}
// todo lav packages til hver exsercise og flyt filerne derhen