package com.security.parkinglotsystem.service;

import com.security.parkinglotsystem.model.Ticket;
import com.security.parkinglotsystem.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TicketService {
    private Map<String, Ticket> ticketMap = new ConcurrentHashMap<>();
    public Ticket createTicket(Vehicle vehicle, int floorNumber, int slotNumber) {

        Ticket ticket=  new Ticket(vehicle.getNumber(), floorNumber, slotNumber);
        ticketMap.put(ticket.getTicketId(), ticket);
        return ticket;
    }

    public Optional<Ticket> getTicket(String ticketId) {
        return Optional.ofNullable(ticketMap.get(ticketId));
    }
    public void removeTicket(String ticketId) {
        ticketMap.remove(ticketId);
    }

}
