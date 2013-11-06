package com.tw.stategy;

import com.tw.Parkable;

import java.util.List;

public class SmartChooser implements Chooser{
    @Override
    public Parkable chooseFreePort(List<Parkable> parkingLots) {
        int maxAvailablePort = 0;
        Parkable lot = null;
        for (Parkable parkingLot : parkingLots) {
            if (parkingLot.getFreeCarport() > maxAvailablePort) {
                maxAvailablePort = parkingLot.getFreeCarport();
                lot = parkingLot;
            }
        }
        return lot;
    }
}
