package com.security.parkinglotsystem.manager;

import com.security.parkinglotsystem.constant.FallbackMessageConstant;
import com.security.parkinglotsystem.exception.InvalidTicketException;
import com.security.parkinglotsystem.exception.NoAvailableSlotException;
import com.security.parkinglotsystem.model.ParkingFloor;
import com.security.parkinglotsystem.model.ParkingSlot;
import com.security.parkinglotsystem.model.Ticket;
import com.security.parkinglotsystem.model.Vehicle;
import com.security.parkinglotsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotManager {
    private List<ParkingFloor> floors;

    @Autowired
    private TicketService ticketService;


    public void initialize(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            ParkingSlot availableSlot = floor.getAvailableSlot(vehicle.getType());
            if (availableSlot != null) {
                availableSlot.assignVehicle(vehicle);
                return ticketService.createTicket(vehicle, floor.getFloorNumber(), availableSlot.getSlotNumber());
            }
        }
        throw new NoAvailableSlotException(FallbackMessageConstant.NO_AVAILABLE_SLOT + vehicle.getType());
    }

    public String unparkVehicle(String ticketId) {
        Ticket ticket = ticketService.getTicket(ticketId)
                .orElseThrow(() -> new InvalidTicketException(
                        FallbackMessageConstant.TICKET_NOT_FOUND + ticketId));


        ParkingFloor floor = floors.stream()
                .filter(f -> f.getFloorNumber() == ticket.getFloorNumber())
                .findFirst()
                .orElse(null);

        if (floor == null) {
            throw new IllegalStateException("Floor not found for a valid ticket. Ticket ID: " + ticketId);
        }

        ParkingSlot slot = floor.getSlot(ticket.getSlotNumber());
        if (slot == null || !slot.isOccupied()) {
            throw new InvalidTicketException(FallbackMessageConstant.SLOT_NOT_OCCUPIED + ticket.getSlotNumber());
        }

        slot.unassignVehicle();
        ticketService.removeTicket(ticketId);

        return FallbackMessageConstant.VEHICLE_UNPARKED_SUCCESSFULLY;
    }

}
