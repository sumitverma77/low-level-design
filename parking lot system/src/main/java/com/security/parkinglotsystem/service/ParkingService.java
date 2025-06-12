package com.security.parkinglotsystem.service;

import com.security.parkinglotsystem.dto.ParkVehicleRequest;
import com.security.parkinglotsystem.enums.VehicleType;
import com.security.parkinglotsystem.factory.VehicleFactory;
import com.security.parkinglotsystem.manager.ParkingLotManager;
import com.security.parkinglotsystem.model.Ticket;
import com.security.parkinglotsystem.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {

    @Autowired
    private ParkingLotManager parkingLotManager;

    public Ticket parkVehicle(ParkVehicleRequest request) {
        Vehicle vehicle = VehicleFactory.createVehicle(
                VehicleType.fromString(request.getVehicleType()),
                request.getVehicleNumber()
        );
        return parkingLotManager.parkVehicle(vehicle);
    }
}
