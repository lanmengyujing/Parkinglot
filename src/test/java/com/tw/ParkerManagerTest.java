package com.tw;

import com.tw.stategy.NormalChooser;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkerManagerTest {

    private List<Parkable> boys = new ArrayList<>();
    private Car car;
    private Parkable parkingLot2;


    @Before
    public void setUp() throws Exception {
        car = new Car();
    }

    @Test
    public void should_let_the_park_boys_to_park_car_when_park_boys_have_free_carports() throws Exception {
        Parkable manager = createManagerWithOneBoyHasFreeParkinglots();

        Ticket ticket = manager.park(car);

        assertThat(ticket, notNullValue());
    }

    @Test
    public void should_let_the_park_boys_to_unpark_car_when_car_is_parked_in_parkinglot_of_parking_boys() throws Exception {
        Parkable manager = createManagerWithOneBoyHasFreeParkinglots();
        Ticket ticket = manager.park(car);

        Car fetchedCar = manager.unpark(ticket);

        assertThat(fetchedCar, sameInstance(car));
    }


    @Test
    public void should_park_car_by_himself_when_park_boys_do_not_have_free_carports_and_self_have_carports() throws Exception {
        Parkable manager = createManagerWithBoysNotHaveFreeParkinglots();

        Ticket ticket = manager.park(car);

         assertThat(parkingLot2.unpark(ticket), sameInstance(car));
    }

    @Test
    public void should_unable_park_car_when_park_boys_do_not_have_free_carports_and_self_do_not_have_carports() throws Exception {
        Parkable manager = createManagerWithBoysNotHaveFreeParkinglots();
        parkingLot2.park(new Car());
        parkingLot2.park(new Car());

        assertThat(manager.park(car), nullValue());
    }


    private Parkable createManagerWithOneBoyHasFreeParkinglots() {
        Parkable parkingLot1 = new ParkingLot(20);
        List<Parkable> parkingLots1 = new ArrayList<>();
        parkingLots1.add(parkingLot1);
        boys.add(new ParkingLotBoy(parkingLots1, new NormalChooser()));


        Parkable parkingLot2 = new ParkingLot(10);
        List<Parkable> parkingLots2 = new ArrayList<>();
        parkingLots2.add(parkingLot2);

        return new ParkingLotBoy(parkingLots2, new NormalChooser());
    }

    private Parkable createManagerWithBoysNotHaveFreeParkinglots() {
        Parkable parkingLot1 = new ParkingLot(1);
        List<Parkable> parkingLots1 = new ArrayList<>();
        parkingLots1.add(parkingLot1);
        Parkable boy = new ParkingLotBoy(parkingLots1, new NormalChooser());
        boy.park(new Car());
        boys.add(boy);

        parkingLot2 = new ParkingLot(2);
        List<Parkable> parkingLots2 = new ArrayList<>();
        parkingLots2.add(parkingLot2);

        return new ParkingLotBoy(parkingLots2, new NormalChooser());
    }
}
