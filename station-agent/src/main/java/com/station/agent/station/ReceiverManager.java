package com.station.agent.station;

import com.station.common.domain.Station;

import java.util.HashMap;
import java.util.Map;

public class ReceiverManager {
    private static final Map<String, Receiver> receiverMap = new HashMap<>();

    public static Receiver find(String name) {
        return receiverMap.get(name);
    }

    public static Receiver create(Station station){
        return new SimpleStation(station);
    }
}
