package com.security.parkinglotsystem.manager;

import com.security.parkinglotsystem.constant.FallbackMessageConstant;
import com.security.parkinglotsystem.exception.FloorNotFoundException;
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
import java.util.Map;

@Service
public class ParkingLotManager {
    private List<ParkingFloor> floors;

    @Autowired
    private TicketService ticketService;

    /**
     * Initializes the parking lot with the given floors.
     *
     * @param floors the list of parking floors
     */
    public void initialize(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    /**
     * Parks a vehicle in the parking lot.
     *
     * @param vehicle the vehicle to park
     * @return the ticket for the parked vehicle
     * @throws NoAvailableSlotException if there is no available slot for the vehicle type
     */
    public Ticket parkVehicle(Vehicle vehicle) {
        return floors.stream()
                .flatMap(floor -> floor.getAvailableSlot(vehicle.getType())
                        .map(slot -> Map.entry(floor, slot))
                        .stream())
                .findFirst()
                .map((Map.Entry<ParkingFloor, ParkingSlot> entry) -> {
                    ParkingSlot slot = entry.getValue();
                    slot.assignVehicle(vehicle);
                    return ticketService.createTicket(
                            vehicle,
                            entry.getKey().getFloorNumber(),
                            slot.getSlotNumber()
                    );
                })
                .orElseThrow(() -> new NoAvailableSlotException(FallbackMessageConstant.NO_AVAILABLE_SLOT + vehicle.getType()));
    }

    /**
     * Unparks a vehicle from the parking lot.
     *
     * @param ticketId the id of the ticket to unpark
     * @return a success message
     * @throws InvalidTicketException if the ticket is not found or the slot is not occupied
     * @throws FloorNotFoundException if the floor is not found
     */
    public String unparkVehicle(String ticketId) {
        // 1. Fetch ticket or throw if invalid
        Ticket ticket = ticketService.getTicket(ticketId)
                .orElseThrow(() -> new InvalidTicketException(
                        FallbackMessageConstant.TICKET_NOT_FOUND + ticketId));

        // 2. Find the parking floor for this ticket
        ParkingFloor floor = floors.stream()
                .filter(f -> f.getFloorNumber() == ticket.getFloorNumber())
                .findFirst()
                .orElseThrow(() -> new FloorNotFoundException(
                        FallbackMessageConstant.FLOOR_NOT_FOUND + ticket.getFloorNumber()));

        // 3. Fetch the parking slot and check if occupied, using Optional from getSlot
        ParkingSlot slot = floor.getSlot(ticket.getSlotNumber())
                .filter(ParkingSlot::isOccupied)
                .orElseThrow(() -> new InvalidTicketException(
                        FallbackMessageConstant.SLOT_NOT_OCCUPIED + ticket.getSlotNumber()));

        // 4. Free the slot and remove the ticket
        slot.unassignVehicle();
        ticketService.removeTicket(ticketId);

        return FallbackMessageConstant.VEHICLE_UNPARKED_SUCCESSFULLY;
    }

}
