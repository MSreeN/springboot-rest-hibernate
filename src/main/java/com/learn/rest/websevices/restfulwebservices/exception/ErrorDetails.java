package com.learn.rest.websevices.restfulwebservices.exception;

import java.time.LocalDate;
import java.time.LocalTime;

public class ErrorDetails {
    private LocalTime timestamp;
    private String message;
    private String details;

    public ErrorDetails(LocalTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
