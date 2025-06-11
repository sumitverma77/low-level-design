package com.security.parkinglotsystem.controller;

import com.security.parkinglotsystem.dto.VehicleRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class ParkingController {

    // Placeholder for future methods
     @PostMapping("/park")
     public ResponseEntity<String> parkVehicle(@RequestBody VehicleRequestDTO vehicle)
     {
         return ResponseEntity.ok("Vehicle parked successfully");

     }
}
