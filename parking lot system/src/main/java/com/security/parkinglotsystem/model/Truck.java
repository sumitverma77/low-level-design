package com.security.parkinglotsystem.model;

import com.security.parkinglotsystem.enums.VehicleType;

public class Truck extends Vehicle {

    public Truck(String number) {
        super(number);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }
}
