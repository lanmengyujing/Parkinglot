package com.tw;

import java.util.List;

public class SmarterBoy {

    private List<ParkingLot> parkingLots;


    public SmarterBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        return parkingLots.get(getIndexOfAvailableParkingLot()).park(car);
    }

    private int getIndexOfAvailableParkingLot() {
        int index = 0;
        float maxAvailableRate = (float)0.0;
        float currentRate;
        for (int currentIndex = 0; currentIndex < parkingLots.size(); currentIndex++) {
            currentRate = (parkingLots.get(currentIndex).getAvailablePort())/parkingLots.get(currentIndex).getCapacity();
            if (currentRate > maxAvailableRate) {
                index = currentIndex;
                maxAvailableRate = currentRate;
            }
        }
        return index;
    }

}
