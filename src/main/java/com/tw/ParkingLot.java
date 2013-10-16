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
        this.capacity--;
        Ticket ticket = new Ticket();
        System.out.println(car);
        ticketForCar.put(ticket, car);
        return ticket;

    }

    public int getAvailablePort() {
        return this.capacity;
    }

    public Car unpark(Ticket ticket) {
        this.capacity++;
        return ticketForCar.get(ticket);
    }
}
