package com.tw;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    Map<Ticket, Car> ticketForCar = new HashMap<>();

    public int getCapacity() {
        return capacity;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car) {
        if (getAvailablePort() != 0) {
            Ticket ticket = new Ticket();

            ticketForCar.put(ticket, car);
            return ticket;
        }
        return null;
    }


    public int getAvailablePort() {
        return this.capacity - ticketForCar.size();
    }

    public Car unpark(Ticket ticket) {
        return ticketForCar.remove(ticket);
    }
}
