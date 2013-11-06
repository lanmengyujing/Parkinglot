package com.tw.stategy;

import com.tw.ParkingLot;

import java.util.List;

public class SmartChooser implements Chooser{
    @Override
    public ParkingLot chooseFreePort(List<ParkingLot> parkingLots) {
        int maxAvailablePort = 0;
        ParkingLot lot = null;
        for (ParkingLot parkingLot : parkingLots) {
            //        return this.capacity - ticketForCar.size();
            if (parkingLot.getFreeCarport() > maxAvailablePort) {
                //        return this.capacity - ticketForCar.size();
                maxAvailablePort = parkingLot.getFreeCarport();
                lot = parkingLot;
            }
        }
        return lot;
    }
}
