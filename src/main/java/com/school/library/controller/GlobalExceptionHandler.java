package com.school.library.controller;

import com.school.library.model.response.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<GenericResponse<String>> handleRuntimeException(RuntimeException ex) {
        if ("Validation failed".equals(ex.getMessage()) || "Email already exists".equals(ex.getMessage())) {
            GenericResponse<String> response = GenericResponse.<String>builder()
                    .error(ex.getMessage())
                    .build();
            return ResponseEntity.badRequest().body(response);
        }
        
        GenericResponse<String> response = GenericResponse.<String>builder()
                .error("Internal server error")
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}