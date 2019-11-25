package com.dio.demo.springdoc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidParameterException extends Exception {

    public InvalidParameterException(String parameterName, String parameterValue) {
        super(String.format("Invalid value for parameter '%s': '%s'", parameterName, parameterValue));
    }
}
