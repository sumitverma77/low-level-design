package com.security.parkinglotsystem.controller;

import com.security.parkinglotsystem.dto.ParkVehicleRequest;
import com.security.parkinglotsystem.dto.ResponseWrapper;
import com.security.parkinglotsystem.dto.UnparkVehicleRequest;
import com.security.parkinglotsystem.model.Ticket;
import com.security.parkinglotsystem.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class ParkingController {
    @Autowired
    private ParkingService parkingService;

    @PostMapping("/park")
    public ResponseEntity<ResponseWrapper<Ticket>> parkVehicle(@RequestBody ParkVehicleRequest request) {
        return parkingService.parkVehicle(request);
    }

    @PostMapping("/unpark")
    public ResponseEntity<ResponseWrapper<String>> unparkVehicle(@RequestBody UnparkVehicleRequest request) {
        return parkingService.unparkVehicle(request);
    }
}
