package com.station.agent.station;

import java.util.HashMap;
import java.util.Map;

public class ReceiverManager {
    private static final Map<String, Receiver> receiverMap = new HashMap<>();

    public static Receiver find(String name) {
        return receiverMap.get(name);
    }
}
