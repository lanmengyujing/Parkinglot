package com.tw;

import com.tw.stategy.NormalChooser;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReporterTest {
    @Test
    public void should_report_in_stand_format() throws Exception {
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        parkingLot2.park(new Car());
        ParkingLot parkingLot3 = new ParkingLot(10);
        ParkingLotBoy parker1 = new ParkingLotBoy(Arrays.<Parkable>asList(parkingLot1, parkingLot2), new NormalChooser());
        ParkingLotBoy parker2 = new ParkingLotBoy(Arrays.<Parkable>asList(parker1), new NormalChooser());
        ParkingLotBoy parkingManager = new ParkingLotBoy(Arrays.<Parkable>asList(parkingLot3), new NormalChooser());
        ParkingLotBoy superManager = new ParkingLotBoy(Arrays.<Parkable>asList(parker2, parkingManager), new NormalChooser());


        StringBuilder stringBuilder = new StringBuilder();
        String report = "ParkingLotBoy\n" +
                "--ParkingLotBoy\n" +
                "----ParkingLotBoy\n" +
                "------ParkingLot(10/10)\n" +
                "------ParkingLot(10/9)\n" +
                "--ParkingLotBoy\n" +
                "----ParkingLot(10/10)\n";

        Reporter reporter = new Reporter(0, stringBuilder);
        StringBuilder output = superManager.apply(reporter);

        assertThat(output.toString(), is(report));
    }
}
