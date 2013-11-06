package com.tw.stategy;

import com.tw.Parkable;

import java.util.List;

public class SmarterChooser implements Chooser{
    @Override
    public Parkable chooseFreePort(List<Parkable> parkingLots) {
        float maxAvailableRate = (float) 0.0;
        float currentRate;
        Parkable freeParkingLot = null;
        for (Parkable parkingLot : parkingLots) {
            currentRate = parkingLot.freeRate();
            if (currentRate > maxAvailableRate) {
                maxAvailableRate = currentRate;
                freeParkingLot = parkingLot;
            }
        }
        return freeParkingLot;
    }

}
