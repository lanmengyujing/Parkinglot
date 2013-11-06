package com.tw;

public class ParkingLot {
    private int capacity;
    private int freeCarport;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.freeCarport = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFreeCarport() {
        return freeCarport;
    }


    public Ticket park(Car car) {
        if (freeCarport != 0) {
            freeCarport--;
            Ticket ticket = new Ticket(car);
            return ticket;
        }
        return null;
    }

    public Car unpark(Ticket ticket) {
        freeCarport++;
        return ticket.getCar();
    }
}
