package com.tw;

import com.tw.stategy.SmartChooser;

import java.util.List;

public class SmartBoy {

    private List<ParkingLot> parkingLots;

    public SmartBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }


    public Ticket park(Car car) {
        SmartChooser parker = new SmartChooser();
        ParkingLot lot = parker.chooseFreePort(parkingLots);
        return lot.park(car);
    }


}
