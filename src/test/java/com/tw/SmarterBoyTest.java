package com.tw;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SmarterBoyTest {
    private SmarterBoy boy;
    private Car car1;
    private Car car2;
    ParkingLot parkingLot1;
    ParkingLot parkingLot2;

    @Before
    public void setUp() throws Exception {
        car1 = new Car();
        car2 = new Car();

        parkingLot1 = new ParkingLot(2);
        parkingLot2 = new ParkingLot(5);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        boy = new SmarterBoy(parkingLots);
    }

    @Test
    public void should_park_car_in_parking_lot_with_more_free_lot() throws Exception {
        boy.park(car1);
        assertThat(parkingLot1.getAvailablePort(), is(1));
        assertThat(parkingLot2.getAvailablePort(), is(5));
        boy.park(car2);
        assertThat(parkingLot1.getAvailablePort(), is(1));
        assertThat(parkingLot2.getAvailablePort(), is(4));
    }


}
