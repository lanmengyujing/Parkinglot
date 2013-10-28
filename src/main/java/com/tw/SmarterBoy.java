package com.tw;

import com.tw.stategy.SmarterChooser;

import java.util.List;

public class SmarterBoy {

    private List<ParkingLot> parkingLots;


    public SmarterBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        SmarterChooser parker = new SmarterChooser();
        ParkingLot parkingLot = parker.chooseFreePort(parkingLots);
        return parkingLot.park(car);
    }


}
