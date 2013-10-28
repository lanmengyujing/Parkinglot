package com.tw;

class NormalPark implements Parker {
    @Override
    public Ticket park(Car car) {
        for (ParkingLot parkingLot : ParkingLotBoy.getParkingLots()) {
            if (parkingLot.getAvailablePort() != 0) {
                return parkingLot.park(car);
            }
        }
        return null;
    }
}
