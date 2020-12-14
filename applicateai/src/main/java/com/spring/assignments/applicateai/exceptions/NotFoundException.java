package com.spring.assignments.applicateai.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Not Found")
public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Not Found");
    }
    public NotFoundException(String message) {
        super(message);
    }
}
