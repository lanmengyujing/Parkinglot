package com.tw;

import java.util.List;

class NormalChooser {
    public ParkingLot chooseFreePort(List<ParkingLot> parkingLots) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getAvailablePort() != 0) {
                return parkingLot;
            }
        }
        return null;
    }
}
