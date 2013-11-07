package com.tw;

public class ParkingLot implements Parkable {
    private int capacity;
    private int freeCarport;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.freeCarport = capacity;
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

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getFreeCarport() {
        return freeCarport;
    }

    @Override
    public float freeRate() {
        return getFreeCarport() / getCapacity();
    }

    @Override
    public StringBuilder apply(Reporter reporter) {
        return reporter.buildReport(toString());
    }

    @Override
    public String toString() {
        return "ParkingLot"+ "(" + this.getCapacity() + "/" + this.getFreeCarport() + ")" + "\n";
    }
}
