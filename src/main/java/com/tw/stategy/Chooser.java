package com.tw.stategy;

import com.tw.ParkingLot;

import java.util.List;

public interface Chooser {
    ParkingLot chooseFreePort(List<ParkingLot> parkingLots);
}
