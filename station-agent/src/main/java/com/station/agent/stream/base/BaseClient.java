package com.station.agent.stream.base;

import com.station.agent.stream.DataStream;
import com.station.agent.stream.propertys.StreamProperty;
import io.netty.channel.Channel;

public abstract class BaseClient implements DataStream {
    protected Channel channel;
    private final String handlerName = "handler";

    @Override
    public void open() throws Exception {
        BaseHandler handler = new BaseHandler();
        handler.setOwner(getProperty().getOwner());
        channel.pipeline().addLast(handlerName, handler);
    }

    @Override
    public void close() {
        channel.pipeline().remove(handlerName);
        channel.disconnect();
        channel.close();
        channel = null;
    }

    protected abstract StreamProperty getProperty();
}
