package com.tw;

import com.tw.stategy.SmartChooser;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SmartBoyTest {
    private ParkingLotBoy boy;
    private Car car;
    ParkingLot parkingLot1;
    ParkingLot parkingLot2;

    @Before
    public void setUp() throws Exception {
        car = new Car();

        parkingLot1 = new ParkingLot(20);
        parkingLot2 = new ParkingLot(10);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        boy = new ParkingLotBoy(parkingLots, new SmartChooser());
    }

    @Test
    public void should_park_car_in_parking_lot_with_more_free_lot() throws Exception {
        boy.chooser.chooseFreePort(boy.parkingLots).park(car);
        assertThat(parkingLot1.getFreeCarport(), is(19));
        assertThat(parkingLot2.getFreeCarport(), is(10));
    }


}
