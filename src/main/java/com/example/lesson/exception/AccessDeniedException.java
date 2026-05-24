package com.example.lesson.exception;

public class AccessDeniedException
        extends RuntimeException {

    public AccessDeniedException(String message) {
        super(message);
    }
}