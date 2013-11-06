package com.tw.stategy;

import com.tw.Parkable;

import java.util.List;

public class NormalChooser implements Chooser {
    @Override
    public Parkable chooseFreePort(List<Parkable> parkingLots) {
        for (Parkable parkingLot : parkingLots) {
            if (parkingLot.getFreeCarport() != 0) {
                return parkingLot;
            }
        }
        return null;
    }
}
