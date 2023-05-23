package com.viepovsky.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(StudentExistsException.class)
    ResponseEntity<String> handleStudentExistsException(StudentExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    @ExceptionHandler(StudentNotFoundException.class)
    ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
