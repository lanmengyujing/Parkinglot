package com.tw.stategy;

import com.tw.ParkingLot;

import java.util.List;

public class NormalChooser implements Chooser{
    @Override
    public ParkingLot chooseFreePort(List<ParkingLot> parkingLots) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getAvailablePort() != 0) {
                return parkingLot;
            }
        }
        return null;
    }
}
