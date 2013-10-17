package com.tw;

import java.util.List;

public class ParkingLotBoy {


    private List<ParkingLot> parkingLots;

    public ParkingLotBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getAvailablePort() != 0) {
                return parkingLot.park(car);
            }
        }
        return null;
    }

    public Car unpark(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.unpark(ticket) != null) {
                return parkingLot.unpark(ticket);
            }
        }
        return null;
    }
}
