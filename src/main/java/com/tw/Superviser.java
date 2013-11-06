package com.tw;

import java.util.List;

public class Superviser implements Parkable{
    private List<Parkable> managers;

    public Superviser(List<Parkable> managers) {
        this.managers = managers;
    }

    @Override
    public Ticket park(Car car) {
        Ticket ticket = null;
        for (Parkable manager : managers) {
            ticket = manager.park(car);
            if (ticket != null) {
                break;
            }
        }
        return ticket;
    }

    public Car unpark(Ticket ticket) {
        Car car = null;
        for (Parkable manager : managers) {
            car = manager.unpark(ticket);
            if (car != null) {
                break;
            }
        }
        return car;
    }
}
