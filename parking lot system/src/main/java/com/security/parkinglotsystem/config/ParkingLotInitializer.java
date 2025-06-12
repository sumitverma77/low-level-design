package com.security.parkinglotsystem.config;

import com.security.parkinglotsystem.enums.VehicleType;
import com.security.parkinglotsystem.manager.ParkingLotManager;
import com.security.parkinglotsystem.model.ParkingFloor;
import com.security.parkinglotsystem.model.ParkingSlot;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ParkingLotInitializer {
    @Autowired
    private ParkingLotManager parkingLotManager;

    @PostConstruct
    public void setUpParkingLot() {

        List<ParkingSlot> floor1Slots = Arrays.asList(
                new ParkingSlot(1, VehicleType.CAR),
                new ParkingSlot(2, VehicleType.BIKE),
                new ParkingSlot(3, VehicleType.TRUCK)
        );

        List<ParkingSlot> floor2Slots = Arrays.asList(
                new ParkingSlot(1, VehicleType.CAR),
                new ParkingSlot(2, VehicleType.BIKE),
                new ParkingSlot(3, VehicleType.TRUCK)
        );


        ParkingFloor floor1 = new ParkingFloor(1, floor1Slots);
        ParkingFloor floor2 = new ParkingFloor(2, floor2Slots);

        parkingLotManager.initialize(Arrays.asList(floor1, floor2));
    }
}
