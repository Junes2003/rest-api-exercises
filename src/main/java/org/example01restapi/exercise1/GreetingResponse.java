package org.example01restapi.exercise1;

import java.time.LocalDateTime;

public class GreetingResponse {

    private String message;
    private LocalDateTime timestamp;

    public GreetingResponse(String message, LocalDateTime timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
