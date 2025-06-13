package com.security.parkinglotsystem.service;

import com.security.parkinglotsystem.constant.FallbackMessageConstant;
import com.security.parkinglotsystem.dto.ParkVehicleRequest;
import com.security.parkinglotsystem.dto.ResponseWrapper;
import com.security.parkinglotsystem.enums.VehicleType;
import com.security.parkinglotsystem.factory.VehicleFactory;
import com.security.parkinglotsystem.manager.ParkingLotManager;
import com.security.parkinglotsystem.model.Ticket;
import com.security.parkinglotsystem.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {

    @Autowired
    private ParkingLotManager parkingLotManager;

    public ResponseEntity<ResponseWrapper<Ticket>> parkVehicle(ParkVehicleRequest request) {
        Vehicle vehicle = VehicleFactory.createVehicle(
                VehicleType.fromString(request.getVehicleType()),
                request.getVehicleNumber()
        );
return ResponseEntity.ok(new ResponseWrapper<>(FallbackMessageConstant.VEHICLE_PARKED_SUCCESSFULLY, parkingLotManager.parkVehicle(vehicle)));
    }

    public ResponseEntity<ResponseWrapper<String>> unparkVehicle(String ticketId) {
         return ResponseEntity.ok(new ResponseWrapper<>(FallbackMessageConstant.VEHICLE_UNPARKED_SUCCESSFULLY, parkingLotManager.unparkVehicle(ticketId)));
    }
}
