package com.security.parkinglotsystem.model;

import com.security.parkinglotsystem.enums.VehicleType;

import java.util.List;

public class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSlot> slots;

    public ParkingFloor(int floorNumber, List<ParkingSlot> slots) {
        this.floorNumber = floorNumber;
        this.slots = slots;
    }

    public ParkingSlot getAvailableSlot(VehicleType type) {
        for (ParkingSlot slot : slots) {
            if (slot.getType() == type && slot.isAvailable()) {
                return slot;
            }
        }
        return null;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }
}
