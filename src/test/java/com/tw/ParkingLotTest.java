package com.tw;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;


public class ParkingLotTest {
    Parkable parkingLot;
    Car car;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(3);
        car = new Car();
    }

    @Test
    public void should_be_able_to_park_car() throws Exception {
        Ticket ticket = parkingLot.park(car);
        assertThat(ticket instanceof Ticket, is(true));
    }

    @Test
    public void should_be_able_to_unpark_car() throws Exception {
        Ticket ticket = parkingLot.park(car);
        Car fetchedCar = parkingLot.unpark(ticket);
        assertThat(fetchedCar, sameInstance(car));
    }

    @Test
    public void should_reduce_carports_when_park_car() throws Exception {
        parkingLot.park(car);
        assertThat(parkingLot.getFreeCarport(), is(2));
    }

    @Test
    public void should_increase_carports_when_unpark_car() throws Exception {
        Ticket ticket = parkingLot.park(car);
        Car fetchedCar = parkingLot.unpark(ticket);

        Car car2 = new Car();
        Ticket ticket1 = parkingLot.park(car2);
        Car fetchedCar2 = parkingLot.unpark(ticket1);
        assertThat(fetchedCar, sameInstance(car));
        assertThat(fetchedCar2, sameInstance(car2));

        assertThat(parkingLot.getFreeCarport(), is(3));
    }

    @Test
    public void should_not_able_to_park_when_is_full() throws Exception {
         parkingLot.park(car);
         parkingLot.park(car);
         parkingLot.park(car);

         assertThat(parkingLot.park(car), nullValue());
    }
}
