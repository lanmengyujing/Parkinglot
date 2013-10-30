package com.tw;

import com.tw.stategy.Chooser;

import java.util.List;

public class ParkingLotBoy {
    public List<ParkingLot> parkingLots;
    public Chooser chooser;

    public ParkingLotBoy(List<ParkingLot> parkingLots, Chooser chooser) {
        this.parkingLots = parkingLots;
        this.chooser = chooser;
    }

    public Ticket park(Car car) {
        return chooser.chooseFreePort(parkingLots).park(car);
    }

    public Car unpark(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            Car car = parkingLot.unpark(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }
}
