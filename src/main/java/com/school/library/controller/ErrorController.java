package com.school.library.controller;

import com.school.library.model.response.GenericResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import tools.jackson.databind.json.JsonMapper;

@RestControllerAdvice
public class ErrorController {
    private final JsonMapper.Builder builder;

    public ErrorController(JsonMapper.Builder builder) {
        this.builder = builder;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<GenericResponse<String>> constraintViolationException(ConstraintViolationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(GenericResponse.<String>builder().error(ex.getMessage()).build());
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<GenericResponse<String>> responseStatusException(ResponseStatusException ex) {
        return ResponseEntity.status(ex.getStatusCode())
                .body(GenericResponse.<String>builder().error(ex.getReason()).build());
    }
}
