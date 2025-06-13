package com.security.parkinglotsystem.factory;

import com.security.parkinglotsystem.enums.VehicleType;
import com.security.parkinglotsystem.model.Bike;
import com.security.parkinglotsystem.model.Car;
import com.security.parkinglotsystem.model.Truck;
import com.security.parkinglotsystem.model.Vehicle;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType type, String number) {
        return switch (type) {
            case CAR -> new Car(number);
            case BIKE -> new Bike(number);
            case TRUCK -> new Truck(number);
        };
    }
}
