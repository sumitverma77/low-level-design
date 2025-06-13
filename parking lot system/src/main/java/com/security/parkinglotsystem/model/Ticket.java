package com.security.parkinglotsystem.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private final String ticketId;
    private final String vehicleNumber;
    private final int floorNumber;
    private final int slotNumber;
    private final LocalDateTime issuedAt;

    public Ticket(String vehicleNumber, int floorNumber, int slotNumber) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicleNumber = vehicleNumber;
        this.floorNumber = floorNumber;
        this.slotNumber = slotNumber;
        this.issuedAt = LocalDateTime.now();
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }
}
