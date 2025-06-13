package com.security.parkinglotsystem.model;

import com.security.parkinglotsystem.enums.VehicleType;

import java.util.List;
import java.util.Optional;

public class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSlot> slots;

    /**
     * Constructs a ParkingFloor object.
     * @param floorNumber the floor number of the parking floor
     * @param slots the list of parking slots on the floor
     */
    public ParkingFloor(int floorNumber, List<ParkingSlot> slots) {
        this.floorNumber = floorNumber;
        this.slots = slots;
    }

    /**
     * Returns an available parking slot for the given vehicle type.
     * @param type the vehicle type to search for
     * @return an Optional containing the available ParkingSlot if found, otherwise empty Optional
     */
    public Optional<ParkingSlot> getAvailableSlot(VehicleType type) {
        return slots.stream()
                .filter(slot -> slot.getType() == type && slot.isAvailable())
                .findFirst();
    }

    /**
     * Returns the ParkingSlot matching the given slot number if present.
     *
     * @param slotNumber the slot number to search for
     * @return Optional containing the ParkingSlot if found, otherwise empty Optional
     */
    public Optional<ParkingSlot> getSlot(int slotNumber) {
        return slots.stream()
                .filter(slot -> slot.getSlotNumber() == slotNumber)
                .findFirst();
    }

    /**
     * Returns the floor number of the parking floor.
     * @return the floor number
     */
    public int getFloorNumber() {
        return floorNumber;
    }

    /**
     * Returns the list of parking slots on the floor.
     * @return the list of parking slots
     */
    public List<ParkingSlot> getSlots() {
        return slots;
    }
}
