package com.security.parkinglotsystem.exception;

public class InvalidVehicleTypeException extends RuntimeException {

    public InvalidVehicleTypeException(String message) {
        super(message);
    }

    public InvalidVehicleTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidVehicleTypeException(Throwable cause) {
        super(cause);
    }

}
