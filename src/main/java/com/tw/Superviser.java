package com.tw;

import java.util.List;

public class Superviser{
    private List<ParkerManager> managers;

    public Superviser(List<ParkerManager> managers) {
        this.managers = managers;
    }

    public Ticket park(Car car) {
        Ticket ticket = null;
        for (ParkerManager manager : managers) {
            ticket = manager.park(car);
            if (ticket != null) {
                break;
            }
        }
        return ticket;
    }

    public Car unpark(Ticket ticket) {
        Car car = null;
        for (ParkerManager manager : managers) {
            car = manager.unpark(ticket);
            if (car != null) {
                break;
            }
        }
        return car;
    }
}
