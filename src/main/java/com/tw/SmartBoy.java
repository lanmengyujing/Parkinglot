package com.tw;

import com.tw.stategy.SmartChooser;

import java.util.List;

public class SmartBoy {
    private List<ParkingLot> parkingLots;
    private SmartChooser smartChooser;

    public SmartBoy(List<ParkingLot> parkingLots, SmartChooser smartChooser) {
        this.smartChooser = smartChooser;
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        ParkingLot lot = smartChooser.chooseFreePort(parkingLots);
        return lot.park(car);
    }
}
