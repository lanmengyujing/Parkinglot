package com.tw;

import com.tw.stategy.NormalChooser;

import java.util.List;

public class ParkingLotBoy {
    public List<ParkingLot> parkingLots;
    public NormalChooser normalChooser;

    public ParkingLotBoy(List<ParkingLot> parkingLots, NormalChooser normalChooser) {
        this.parkingLots = parkingLots;
        this.normalChooser = normalChooser;
    }

    public Ticket park(Car car) {
        ParkingLot lot = normalChooser.chooseFreePort(parkingLots);
        return lot.park(car);
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
