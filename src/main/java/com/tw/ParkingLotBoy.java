package com.tw;

import java.util.List;

public class ParkingLotBoy implements Parker {


    public static List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public  static List<ParkingLot> parkingLots;
    public  NormalPark normalPark;

    public ParkingLotBoy(List<ParkingLot> parkingLots, NormalPark normalPark ) {
        this.parkingLots = parkingLots;
        this.normalPark = normalPark;
    }

    public Ticket park(Car car) {

        return normalPark.park(car);
    }

    public Car unpark(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            Car car = parkingLot.unpark(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }

}
