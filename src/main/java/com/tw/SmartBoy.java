package com.tw;

import java.util.List;

public class SmartBoy {
    private List<ParkingLot> parkingLots;

    public SmartBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        ParkingLot lot = this.getFreeLot();
        return lot.park(car);
    }

    private ParkingLot getFreeLot() {
        int maxAvailablePort = 0;
        ParkingLot lot = null;
        for (ParkingLot parkingLot : parkingLots) {
            maxAvailablePort = Math.max(parkingLot.getAvailablePort(), maxAvailablePort);
            lot = parkingLot;
        }
        return lot;
    }
}
