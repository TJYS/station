package com.station.agent.station;

import java.util.Arrays;

public class Station implements Receiver{
    @Override
    public void onData(byte[] bytes) {
        System.out.println(Arrays.toString(bytes));
    }
}
