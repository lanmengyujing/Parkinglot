package com.tw;

public class ParkingLot implements Parkable{
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

    @Override
    public Ticket park(Car car) {
        if (freeCarport != 0) {
            freeCarport--;
            return new Ticket(car);
        }
        return null;
    }

    @Override
    public Car unpark(Ticket ticket) {
        freeCarport++;
        return ticket.getCar();
    }

    public float freeRate() {
        return getFreeCarport() / getCapacity();
    }
}
