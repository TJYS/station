package com.station.agent.stream.impl;

import com.station.agent.stream.DataStream;
import com.station.agent.stream.DataStreamCreator;
import com.station.agent.stream.propertys.StreamProperty;
import org.springframework.stereotype.Component;

@Component("TcpClientDataStreamCreator")
public class TcpClientDataStreamCreator implements DataStreamCreator {
    @Override
    public DataStream create(StreamProperty property) {
        return null;
    }
}
