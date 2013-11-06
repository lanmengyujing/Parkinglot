package com.tw;

import com.tw.stategy.Chooser;

import java.util.ArrayList;
import java.util.List;

public class ParkerManager implements Parkable {
    private List<Parkable> parkables = new ArrayList<Parkable>();
    private Chooser chooser;

    public ParkerManager(List<Parkable> boys, List<ParkingLot> parkingLots, Chooser chooser) {
        this.chooser = chooser;
        for (Parkable boy : boys) {
            parkables.add(boy);
        }
        for (ParkingLot parkingLot : parkingLots) {
            parkables.add(parkingLot);
        }
    }

    @Override
    public Ticket park(Car car) {
        Ticket ticket = null;
        for (Parkable parkable : parkables) {
            ticket = parkable.park(car);
            if (ticket != null) {
                break;
            }
        }
        return ticket;
    }

    @Override
    public Car unpark(Ticket ticket) {
        for (Parkable parkable : parkables) {
            Car car = parkable.unpark(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }

}
