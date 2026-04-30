package com.pqromnicmandap.flightseatbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class AlreadyAvailableException extends RuntimeException {
    public AlreadyAvailableException(String message) {
        super(message);
    }

    public AlreadyAvailableException(String message, Throwable cause){
        super(message, cause);
    }
}
