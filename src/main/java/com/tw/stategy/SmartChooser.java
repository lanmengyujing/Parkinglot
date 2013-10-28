package com.tw.stategy;

import com.tw.ParkingLot;

import java.util.List;

public class SmartChooser implements Chooser{
    @Override
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
