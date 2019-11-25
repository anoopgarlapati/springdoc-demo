package com.dio.demo.springdoc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateUserException extends Exception {

    public DuplicateUserException(String username) {
        super(String.format("User with username: '%s' already exists.", username));
    }
}
