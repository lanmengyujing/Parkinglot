package com.tw;

import com.tw.stategy.Chooser;

import java.util.List;

public class ParkingLotBoy implements Parkable{
    public List<ParkingLot> parkingLots;
    public Chooser chooser;

    public ParkingLotBoy(List<ParkingLot> parkingLots, Chooser chooser) {
        this.parkingLots = parkingLots;
        this.chooser = chooser;
    }

    @Override
    public Ticket park(Car car) {
        Ticket ticket = null;
        ParkingLot parkingLot = chooser.chooseFreePort(parkingLots);
        if (parkingLot != null) {
            ticket = parkingLot.park(car);
        }
        return ticket;
    }

    @Override
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
