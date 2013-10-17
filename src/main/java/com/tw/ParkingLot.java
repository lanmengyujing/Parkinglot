package com.tw;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity;

    Map<Ticket, Car> ticketForCar = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car) {
        if (this.capacity != 0) {
            this.capacity--;
            Ticket ticket = new Ticket();

            ticketForCar.put(ticket, car);
            return ticket;
        }
        return null;
    }

    public int getAvailablePort() {
        return this.capacity;
    }

    public Car unpark(Ticket ticket) {
        this.capacity ++;
        return ticketForCar.get(ticket);
    }
}
