package com.security.parkinglotsystem.model;

import com.security.parkinglotsystem.enums.VehicleType;

public class ParkingSlot {
    private final int slotNumber;
    private final VehicleType type;
    private boolean occupied;
    private Vehicle vehicle;

    public ParkingSlot(int slotNumber, VehicleType type) {
        this.slotNumber = slotNumber;
        this.type = type;
        this.occupied = false;
    }

    public boolean isAvailable() {
        return !occupied;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.occupied = true;
    }

    public void unassignVehicle() {
        this.vehicle = null;
        this.occupied = false;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleType getType() {
        return type;
    }

    public boolean isOccupied() {
        return occupied;
    }
}
