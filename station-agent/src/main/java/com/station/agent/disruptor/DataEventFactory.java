package com.station.agent.disruptor;

import com.lmax.disruptor.EventFactory;

public class DataEventFactory implements EventFactory<DataEvent> {
    @Override
    public DataEvent newInstance() {
        return new DataEvent();
    }
}
