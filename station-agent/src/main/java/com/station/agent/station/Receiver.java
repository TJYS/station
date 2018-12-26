package com.station.agent.station;

import com.station.common.domain.Station;

public interface Receiver {
    void onData(byte[] bytes);

    Station getProperty();
}
