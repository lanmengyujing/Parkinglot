package com.tw;

import com.tw.stategy.SmarterChooser;

import java.util.List;

public class SmarterBoy {

    private List<ParkingLot> parkingLots;
    private SmarterChooser smarterChooser;

    SmarterBoy(List<ParkingLot> parkingLots, SmarterChooser smarterChooser) {
        this.parkingLots = parkingLots;
        this.smarterChooser = smarterChooser;
    }

    public Ticket park(Car car) {
        ParkingLot parkingLot = smarterChooser.chooseFreePort(parkingLots);
        return parkingLot.park(car);
    }
}
