package com.tw;

import com.tw.stategy.Chooser;

import java.util.List;

public class SmartBoy extends ParkingLotBoy {
    public SmartBoy(List<ParkingLot> parkingLots, Chooser chooser) {
        super(parkingLots, chooser);
    }

    public Ticket park(Car car) {
        return chooser.chooseFreePort(parkingLots).park(car);
    }
}
