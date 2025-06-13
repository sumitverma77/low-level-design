package com.security.parkinglotsystem.exception;

public class FloorNotFoundException extends RuntimeException {

    public FloorNotFoundException(String message) {
        super(message);
    }

    public FloorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FloorNotFoundException(Throwable cause) {
        super(cause);
    }
}
