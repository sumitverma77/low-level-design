package com.security.parkinglotsystem.model;

import com.security.parkinglotsystem.enums.VehicleType;

public class Car extends Vehicle {

    public Car(String number) {
        super(number);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }
}
