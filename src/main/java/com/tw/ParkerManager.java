package com.tw;

import com.tw.stategy.Chooser;

import java.util.List;

public class ParkerManager {
    private List<ParkingLotBoy> boys;
    private List<ParkingLot> parkingLots;
    private Chooser chooser;

    public ParkerManager(List<ParkingLotBoy> boys, List<ParkingLot> parkingLots, Chooser chooser) {
        this.chooser = chooser;
        this.parkingLots = parkingLots;
        this.boys = boys;
    }

    public Ticket park(Car car) {
        Ticket ticket = null;
        for (ParkingLotBoy boy : boys) {
            ticket = boy.park(car);
            if (ticket != null) {
                return ticket;
            }
        }

        ParkingLot parkingLot = chooser.chooseFreePort(parkingLots);
        if (parkingLot != null) {
            ticket = parkingLot.park(car);
        }
        return ticket;
    }

    public Car unpark(Ticket ticket) {
        for (ParkingLotBoy boy : boys) {
            Car car = boy.unpark(ticket);
            if (car != null) {
                return car;
            }
            return this.fetchCar(ticket);
        }
        return null;
    }

    private Car fetchCar(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            Car car = parkingLot.unpark(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }

}
