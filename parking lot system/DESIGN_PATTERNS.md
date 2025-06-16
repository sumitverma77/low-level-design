# Design Patterns in Parking Lot System

This document describes the design patterns used in the Parking Lot System.

## 1. Factory Pattern

### Purpose

The Factory pattern is used to create instances of different vehicle types (Car, Bike, Truck) in a centralized and decoupled manner.

### Implementation

The `VehicleFactory` class implements the Factory pattern. It has a `createVehicle` method that takes a `VehicleType` as input and returns a concrete `Vehicle` object.

```java
public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType type, String number) {
        return switch (type) {
            case CAR -> new Car(number);
            case BIKE -> new Bike(number);
            case TRUCK -> new Truck(number);
        };
    }
}
```

### Benefits

*   Decouples the client code from the concrete vehicle classes.
*   Provides a centralized way to create vehicle objects.
*   Makes it easy to add new vehicle types without modifying the client code.


## 2. Singleton Pattern

### Purpose

The Singleton pattern ensures that only one instance of a class is created and provides a global point of access to it.

### Implementation

The `TicketService` class is managed as a Singleton by the Spring framework due to the `@Service` annotation.

```java
@Service
public class TicketService {
    private final Map<String, Ticket> ticketMap = new ConcurrentHashMap<>();

    public Ticket createTicket(Vehicle vehicle, int floorNumber, int slotNumber) {

        Ticket ticket = new Ticket(vehicle.getNumber(), floorNumber, slotNumber);
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
```

### Benefits

*   Ensures that only one instance of the `TicketService` is created.
*   Provides a global point of access to the `TicketService`.
*   Simplifies the management of tickets.
