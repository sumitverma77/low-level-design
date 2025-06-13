package com.security.parkinglotsystem.exception;

import com.security.parkinglotsystem.dto.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice()
public class GlobalExceptionHandler {

    public ResponseEntity<ResponseWrapper<Object>> handleInvalidVehicleTypeException(InvalidVehicleTypeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ResponseWrapper<>(ex.getMessage(), null));
    }

    @ExceptionHandler(NoAvailableSlotException.class)
    public ResponseEntity<ResponseWrapper<Object>> handleNoSlot(NoAvailableSlotException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ResponseWrapper<>(ex.getMessage(), null));
    }

    @ExceptionHandler(InvalidTicketException.class)
    public ResponseEntity<ResponseWrapper<Object>> handleInvalidTicket(InvalidTicketException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseWrapper<>(ex.getMessage(), null));
    }

    @ExceptionHandler(FloorNotFoundException.class)
    public ResponseEntity<ResponseWrapper<Object>> handleFloorNotFound(FloorNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseWrapper<>(ex.getMessage(), null));
    }
}
