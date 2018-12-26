package com.station.agent.station;

import com.station.common.domain.Station;

import java.util.Arrays;

public class SimpleStation implements Receiver{
    private Station model;
    public SimpleStation(Station model) {
        this.model = model;
    }

    @Override
    public void onData(byte[] bytes) {
        System.out.println(Arrays.toString(bytes));
    }

    @Override
    public Station getProperty() {
        return this.model;
    }
}
