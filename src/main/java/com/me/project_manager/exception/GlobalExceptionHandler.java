package com.me.project_manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<String> handleProjectNotFoundException(ProjectNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(ProjectUrlAlreadyExistsException.class)
    public ResponseEntity<String> handleProjectAlreadyExistsException(ProjectUrlAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error interno del servidor: " + e.getMessage());
    }

}
