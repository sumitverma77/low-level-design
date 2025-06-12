package com.security.parkinglotsystem.exception;

public class NoAvailableSlotException extends RuntimeException{

    public NoAvailableSlotException(String message) {
        super(message);
    }

    public NoAvailableSlotException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoAvailableSlotException(Throwable cause) {
        super(cause);
    }
}
