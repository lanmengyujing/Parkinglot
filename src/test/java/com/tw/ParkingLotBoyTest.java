package com.tw;

import com.tw.stategy.NormalChooser;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingLotBoyTest {
    private Parkable boy;
    private Car car;


    @Before
    public void setUp() throws Exception {
        car = new Car();
        List<Parkable> parkingLots = Arrays.<Parkable>asList(new ParkingLot(1), new ParkingLot(2));
        boy = new ParkingLotBoy(parkingLots, new NormalChooser());
    }

    @Test
    public void should_be_able_to_park_car() throws Exception {
        Ticket ticket = boy.park(car);
        assertThat(ticket instanceof Ticket, is(true));
    }

    @Test
    public void should_get_the_same_car_when_unpark_car() throws Exception {
        Ticket ticket = boy.park(car);
        Car fetchedCar = boy.unpark(ticket);
        assertThat(fetchedCar, sameInstance(car));
    }

    @Test
    public void should_be_able_to_park_when_first_lot_is_full_and_the_second_parking_lot_is_not_full() throws Exception {
        boy.park(car);
        Car car2 = new Car();
        Ticket ticket2 = boy.park(car2);
        assertThat(ticket2, notNullValue());
    }
}
