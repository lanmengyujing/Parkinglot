package com.tw;

import java.util.List;

public class SmartBoy {

    private List<ParkingLot> parkingLots;

    public SmartBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }


    public Ticket park(Car car) {
        SmartPark parker = new SmartPark();
        ParkingLot lot = parker.chooseFreePort(parkingLots);
        return lot.park(car);
    }


    private class SmartPark {
        public ParkingLot chooseFreePort(List<ParkingLot> parkingLots) {
            int maxAvailablePort = 0;
            ParkingLot lot = null;
            for (ParkingLot parkingLot : parkingLots) {
                if (parkingLot.getAvailablePort() > maxAvailablePort) {
                    maxAvailablePort = parkingLot.getAvailablePort();
                    lot = parkingLot;
                }
            }
            return lot;
        }
    }
}
