package com.tw;

import com.tw.stategy.Chooser;

import java.util.List;

public class ParkingLotBoy implements Parkable {
    public List<Parkable> parkingLots;
    public Chooser chooser;

    public ParkingLotBoy(List<Parkable> parkingLots, Chooser chooser) {
        this.parkingLots = parkingLots;
        this.chooser = chooser;
    }


    @Override
    public Ticket park(Car car) {
        Ticket ticket = null;
        Parkable parkingLot = chooser.chooseFreePort(parkingLots);
        if (parkingLot != null) {
            ticket = parkingLot.park(car);
        }
        return ticket;
    }

    @Override
    public Car unpark(Ticket ticket) {
        for (Parkable parkingLot : parkingLots) {
            Car car = parkingLot.unpark(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }

    @Override
    public int getFreeCarport() {
        int carport = 0;
        for (Parkable parkingLot : parkingLots) {
            carport += parkingLot.getFreeCarport();
        }
        return carport;
    }

    @Override
    public int getCapacity() {
        int capacity = 0;
        for (Parkable parkingLot : parkingLots) {
            capacity += parkingLot.getCapacity();
        }
        return capacity;
    }

    @Override
    public float freeRate() {
        return getFreeCarport() / getCapacity();
    }

    @Override
    public StringBuilder apply(Reporter reporter) {
        StringBuilder report = reporter.buildReport(toString());
        int depth = reporter.getDepth();
        for (Parkable parkingLot : parkingLots) {
            StringBuilder apply = parkingLot.apply(new Reporter(depth + 1, new StringBuilder()));
            report.append(apply);
        }
        return report;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "\n";
    }


}
