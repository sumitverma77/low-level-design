package com.security.parkinglotsystem.exception;

import com.security.parkinglotsystem.dto.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice()
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidVehicleTypeException.class)
    public ResponseEntity<String> handleInvalidVehicleTypeException(InvalidVehicleTypeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    @ExceptionHandler(NoAvailableSlotException.class)
    public ResponseEntity<ResponseWrapper<Object>> handleNoSlot(NoAvailableSlotException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ResponseWrapper<>(ex.getMessage(), null));
    }


}
