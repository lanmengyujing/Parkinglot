package com.tw.stategy;

import com.tw.Parkable;

import java.util.List;

public interface Chooser {
    Parkable chooseFreePort(List<Parkable> parkingLots);
}
