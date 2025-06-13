package com.security.parkinglotsystem.service;

import com.security.parkinglotsystem.model.Ticket;
import com.security.parkinglotsystem.model.Vehicle;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    public Ticket createTicket(Vehicle vehicle, int floorNumber, int slotNumber) {
        return new Ticket(vehicle.getNumber(), floorNumber, slotNumber);
    }
}
