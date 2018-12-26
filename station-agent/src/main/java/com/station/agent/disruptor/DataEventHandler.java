package com.station.agent.disruptor;

import com.lmax.disruptor.EventHandler;
import com.station.agent.station.Receiver;
import com.station.agent.station.ReceiverManager;

import java.util.Arrays;

public class DataEventHandler implements EventHandler<DataEvent> {
    @Override
    public void onEvent(DataEvent dataEvent, long l, boolean b) throws Exception {
        System.out.println(Arrays.toString(dataEvent.getBytes()));
//        Receiver receiver = ReceiverManager.find(dataEvent.getTopic());
//        if (receiver != null){
//            receiver.onData(dataEvent.getBytes());
//        }
    }
}
