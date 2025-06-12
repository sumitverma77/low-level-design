package com.security.parkinglotsystem.model;

import com.security.parkinglotsystem.enums.VehicleType;
import lombok.Data;

@Data
public abstract class Vehicle {
    protected String number;

    public Vehicle(String number) {
        this.number = number;
    }

    public abstract VehicleType getType();
}
