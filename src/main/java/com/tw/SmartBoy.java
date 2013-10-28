package com.tw;

import java.util.List;

public class SmartBoy {

    private List<ParkingLot> parkingLots;

    public SmartBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }


    public Ticket park(Car car) {
        SmartPark parker = new SmartPark();
        ParkingLot lot = parker.getFreeLot(parkingLots);
        return lot.park(car);
    }


    private class SmartPark {
        public ParkingLot getFreeLot(List<ParkingLot> parkingLots) {
            int maxAvailablePort = 0;
            ParkingLot lot = null;
            for (ParkingLot parkingLot : parkingLots) {
                maxAvailablePort = Math.max(parkingLot.getAvailablePort(), maxAvailablePort);
                lot = parkingLot;
            }
            return lot;
        }
    }
}
