package com.station.agent.disruptor;

import com.lmax.disruptor.EventHandler;
import com.station.agent.station.Receiver;
import com.station.agent.station.ReceiverManager;

public class DataEventHandler implements EventHandler<DataEvent> {
    @Override
    public void onEvent(DataEvent dataEvent, long l, boolean b) throws Exception {
        Receiver receiver = ReceiverManager.find(dataEvent.getTopic());
        if (receiver != null){
            receiver.onData(dataEvent.getBytes());
        }
    }
}
