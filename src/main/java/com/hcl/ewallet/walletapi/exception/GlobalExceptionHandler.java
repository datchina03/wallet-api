package com.hcl.ewallet.walletapi.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<Map<String, String>> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(err -> {
            Map<String, String> e = new HashMap<>();
            e.put("field", err.getField());
            e.put("message", err.getDefaultMessage());
            errors.add(e);
        });

        Map<String, Object> body = new HashMap<>();
        body.put("message", "Validation failed");
        body.put("errors", errors);
        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
        List<Map<String, String>> errors = new ArrayList<>();
        ex.getConstraintViolations().forEach(cv -> {
            Map<String, String> e = new HashMap<>();
            e.put("field", cv.getPropertyPath().toString());
            e.put("message", cv.getMessage());
            errors.add(e);
        });

        Map<String, Object> body = new HashMap<>();
        body.put("message", "Validation failed");
        body.put("errors", errors);
        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "Malformed JSON request");
        if (ex.getMostSpecificCause() != null) {
            body.put("error", ex.getMostSpecificCause().getMessage());
        } else {
            body.put("error", ex.getMessage());
        }
        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAll(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "Internal server error");
        body.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}
