package com.pqromnicmandap.flightseatbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class AlreadyBookedException extends RuntimeException {
    public AlreadyBookedException(String message) {
        super(message);
    }

    public AlreadyBookedException(String message, Throwable cause){
        super(message, cause);
    }
}
