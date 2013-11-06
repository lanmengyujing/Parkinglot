package com.tw;

public interface Parkable {
    Ticket park(Car car);

    Car unpark(Ticket ticket);

    int getFreeCarport();

    int getCapacity();

    float freeRate();
}
