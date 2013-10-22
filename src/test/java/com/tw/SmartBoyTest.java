package com.tw;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SmartBoyTest {
    private SmartBoy boy;
    private Car car;
    ParkingLot parkingLot1;
    ParkingLot parkingLot2;

    @Before
    public void setUp() throws Exception {
        car = new Car();

        parkingLot1 = new ParkingLot(10);
        parkingLot2 = new ParkingLot(20);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        boy = new SmartBoy(parkingLots);
    }

    @Test
    public void should_park_car_in_parking_lot_with_more_free_lot() throws Exception {
        boy.park(car);
        assertThat(parkingLot2.getAvailablePort(), is(19));
        assertThat(parkingLot1.getAvailablePort(), is(10));
    }


}
