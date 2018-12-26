package com.station.agent.stream.client.tcp;

import com.station.agent.stream.DataStream;
import com.station.agent.stream.propertys.StreamProperty;
import io.netty.channel.Channel;

public class TcpClient implements DataStream {
    private Channel channel;
    private StreamProperty property;

    public void setProperty(StreamProperty property) {
        this.property = property;
    }

    public TcpClient(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void open() {
        TcpClientHandler handler = new TcpClientHandler();
        handler.setOwner(property.getOwner());
        channel.pipeline().addLast(handler);
    }

    @Override
    public void close() {
        channel.disconnect();
        channel.close();
        channel = null;
    }
}
