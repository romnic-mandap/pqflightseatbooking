package com.pqromnicmandap.flightseatbooking.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, List<String>>> handleResourceNotFoundException(ResourceNotFoundException ex){
        List<String> errors = Collections.singletonList(ex.getMessage());
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyAvailableException.class)
    public ResponseEntity<Map<String, List<String>>> handleAlreadyAvailableException(AlreadyAvailableException ex){
        List<String> errors = Collections.singletonList(ex.getMessage());
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AlreadyBookedException.class)
    public ResponseEntity<Map<String, List<String>>> handleAlreadyBookedException(AlreadyBookedException ex){
        List<String> errors = Collections.singletonList(ex.getMessage());
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors){
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("error(s)", errors);
        return errorResponse;
    }
}
