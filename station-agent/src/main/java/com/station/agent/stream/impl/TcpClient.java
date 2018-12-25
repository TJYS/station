package com.station.agent.stream.impl;

import com.station.agent.stream.DataStream;
import io.netty.channel.Channel;

public class TcpClient implements DataStream {
    private Channel channel;

    public TcpClient(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void open() {
    }

    @Override
    public void close() {

    }
}
