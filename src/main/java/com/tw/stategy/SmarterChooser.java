package com.tw.stategy;

import com.tw.ParkingLot;

import java.util.List;

public class SmarterChooser implements Chooser{
    @Override
    public ParkingLot chooseFreePort(List<ParkingLot> parkingLots) {
        float maxAvailableRate = (float) 0.0;
        float currentRate;
        ParkingLot freeParkingLot = null;
        for (ParkingLot parkingLot : parkingLots) {
            currentRate = parkingLot.getFreeCarport() / parkingLot.getCapacity();
            if (currentRate > maxAvailableRate) {
                maxAvailableRate = currentRate;
                freeParkingLot = parkingLot;
            }
        }
        return freeParkingLot;
    }
}
