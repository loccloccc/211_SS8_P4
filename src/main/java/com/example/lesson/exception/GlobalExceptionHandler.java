package com.example.lesson.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public Map<String, Object> handleNotFound(
            ResourceNotFoundException exception
    ) {

        Map<String, Object> response = new HashMap<>();

        response.put("status", 404);
        response.put("error", "Not Found");
        response.put("message", exception.getMessage());
        response.put("timestamp", LocalDateTime.now());

        return response;
    }

    @ExceptionHandler(AccessDeniedException.class)
    public Map<String, Object> handleAccessDenied(
            AccessDeniedException exception
    ) {

        Map<String, Object> response = new HashMap<>();

        response.put("status", 403);
        response.put("error", "Forbidden");
        response.put("message", exception.getMessage());
        response.put("timestamp", LocalDateTime.now());

        return response;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, Object> handleConstraintViolation(
            ConstraintViolationException exception
    ) {

        Map<String, Object> response = new HashMap<>();

        response.put("status", 400);
        response.put("error", "Bad Request");
        response.put("message", exception.getMessage());
        response.put("timestamp", LocalDateTime.now());

        return response;
    }

    @ExceptionHandler(Exception.class)
    public Map<String, Object> handleException(
            Exception exception
    ) {

        Map<String, Object> response = new HashMap<>();

        response.put("status", 500);
        response.put("error", "Internal Server Error");
        response.put("message", exception.getMessage());
        response.put("timestamp", LocalDateTime.now());

        return response;
    }
}