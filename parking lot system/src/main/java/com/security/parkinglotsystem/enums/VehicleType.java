package com.security.parkinglotsystem.enums;

import java.util.Arrays;

public enum VehicleType {
    CAR("Car"),
    BIKE("Bike"),
    TRUCK("Truck");

    private final String type;

    VehicleType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static VehicleType fromString(String type) {
        return Arrays.stream(VehicleType.values())
                .filter(vehicleType -> vehicleType.getType().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown vehicle type: " + type));
    }
}
