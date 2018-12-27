package com.station.agent.stream.core.tools;

import com.station.agent.stream.core.DataStream;
import com.station.agent.stream.core.StreamProperty;
import io.netty.channel.Channel;

public abstract class BaseClient implements DataStream {
    protected Channel channel;

    @Override
    public void open() throws Exception {
        BaseHandler handler = new BaseHandler();
        handler.setOwner(getProperty().getOwner());
        channel.pipeline().addLast("handler", handler);
    }

    @Override
    public void close() {
        channel.pipeline().remove("handler");
        channel.disconnect();
        channel.close();
        channel = null;
    }

    protected abstract StreamProperty getProperty();
}
