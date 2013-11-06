package com.tw;

import com.tw.stategy.Chooser;

import java.util.ArrayList;
import java.util.List;

public class ParkerManager extends ParkingLotBoy implements Parkable {
    private List<Parkable> parkables = new ArrayList<Parkable>();

    private ParkerManager(List<Parkable> boys, List<Parkable> parkingLots, Chooser chooser) {
        super(parkingLots, chooser);

        for (Parkable boy : boys) {
            parkables.add(boy);
        }
        for (Parkable parkingLot : parkingLots) {
            parkables.add(parkingLot);
        }
    }

    private ParkerManager(List<Parkable> parkingLots, Chooser chooser) {
        super(parkingLots, chooser);

        for (Parkable parkingLot : parkingLots) {
            parkables.add(parkingLot);
        }
    }

    public static ParkingLotBoy createParkerManager(List<Parkable> boys, List<Parkable> parkingLots, Chooser chooser) {

        return new ParkingLotBoy(parkingLots, chooser);
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
