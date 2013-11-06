package com.tw;

import com.tw.stategy.NormalChooser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

public class SuperviserTest {

    private Car car = new Car();

    @Test
    public void should_let_manager_park_car() throws Exception {
        Superviser superviser = createSuperviser();

        Ticket ticket = superviser.park(car);

        assertThat(ticket, notNullValue());
    }

    @Test
    public void should_let_manager_unpark_car() throws Exception {
        Superviser superviser = createSuperviser();

        Ticket ticket = superviser.park(car);
        Car car1 = superviser.unpark(ticket);

        assertThat(car1, sameInstance(car));
    }

    private Superviser createSuperviser() {
        Parkable manager1 = createManagerWithOneBoyHasFreeParkinglots();
        Parkable manager2 = createManagerWithOneBoyHasFreeParkinglots();

        List<Parkable> managers = Arrays.asList(manager1, manager2);
        return new Superviser(managers);
    }

    private Parkable createManagerWithOneBoyHasFreeParkinglots() {
        List<Parkable> boys = new ArrayList<>();
        Parkable parkable1 = new ParkingLot(20);
        List<Parkable> parkingLots1 = new ArrayList<>();
        parkingLots1.add(parkable1);
        boys.add(new ParkingLotBoy(parkingLots1, new NormalChooser()));


        Parkable parkable2 = new ParkingLot(10);
        List<Parkable> parkingLots2 = new ArrayList<>();
        parkingLots2.add(parkable2);
        return ParkerManager.createParkerManager(boys, parkingLots2, new NormalChooser());
    }
}
