package com.security.parkinglotsystem.model;

import com.security.parkinglotsystem.enums.VehicleType;

public class Bike extends Vehicle {

    public Bike(String number) {
        super(number);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.BIKE;
    }

}
