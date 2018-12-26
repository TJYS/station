package com.station.agent.stream.base;

import com.station.agent.stream.DataStream;
import com.station.agent.stream.client.tcp.TcpClientHandler;
import com.station.agent.stream.propertys.StreamProperty;
import io.netty.channel.Channel;
import io.netty.channel.SimpleChannelInboundHandler;

import java.io.UnsupportedEncodingException;

public abstract class BaseClient implements DataStream {
    protected Channel channel;

    @Override
    public void open() throws UnsupportedEncodingException {
        BaseHandler handler = getHandler();
        handler.setOwner(getProperty().getOwner());
        channel.pipeline().addLast(handler);
    }

    @Override
    public void close() {
        channel.disconnect();
        channel.close();
        channel = null;
    }

    protected abstract BaseHandler getHandler();
    protected abstract StreamProperty getProperty();
}
