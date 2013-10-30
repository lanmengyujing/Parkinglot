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
        for (ParkingLotBoy boy : boys) {
            if (boy.hasAvailableCarport()) {
                return boy.park(car);
            }
        }
        return chooser.chooseFreePort(parkingLots).park(car);
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
