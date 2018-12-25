package com.station.agent.disruptor;

import lombok.Data;

@Data
public class DataEvent {
    private String topic;
    private byte[] bytes;
}
