package com.tw;

import com.tw.stategy.Chooser;

import java.util.List;

public class ParkingLotBoy {
    public List<ParkingLot> parkingLots;
    public Chooser chooser;


    public Chooser getChooser() {
        return chooser;
    }

    public ParkingLotBoy(List<ParkingLot> parkingLots, Chooser chooser) {
        this.parkingLots = parkingLots;
        this.chooser = chooser;
    }

    public Ticket park(Car car) {
        System.out.println(parkingLots);

        return chooser.chooseFreePort(parkingLots).park(car);
    }

    public boolean hasAvailableCarport() {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getAvailablePort() > 0) {
                return true;
            }
        }
        return false;
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
