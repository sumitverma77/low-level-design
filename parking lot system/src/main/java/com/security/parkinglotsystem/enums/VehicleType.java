package com.security.parkinglotsystem.enums;

import com.security.parkinglotsystem.constant.FallbackMessageConstant;
import com.security.parkinglotsystem.exception.InvalidVehicleTypeException;

import java.util.Arrays;

public enum VehicleType {
    CAR("Car"),
    BIKE("Bike"),
    TRUCK("Truck");

    private final String type;

    VehicleType(String type) {
        this.type = type;
    }

    public static VehicleType fromString(String type) {
        return Arrays.stream(VehicleType.values())
                .filter(vehicleType -> vehicleType.getType().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(() -> new InvalidVehicleTypeException(FallbackMessageConstant.UNKNOWN_VEHICLE_TYPE + type));
    }

    public String getType() {
        return type;
    }
}
