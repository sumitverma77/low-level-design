package com.security.parkinglotsystem.exception;

public class InvalidTicketException extends RuntimeException {

    public InvalidTicketException(String message) {
        super(message);
    }

    public InvalidTicketException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTicketException(Throwable cause) {
        super(cause);
    }
}
