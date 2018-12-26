package com.station.agent.stream.base;

import com.station.agent.stream.DataStream;
import com.station.agent.stream.propertys.StreamProperty;
import io.netty.channel.Channel;

public abstract class BaseClient implements DataStream {
    protected Channel channel;

    @Override
    public void open() throws Exception {
        BaseHandler handler = getHandler();
        handler.setOwner(getProperty().getOwner());
        channel.pipeline().addLast(handler);
        afterOpen();
    }

    @Override
    public void close() {
        channel.disconnect();
        channel.close();
        channel = null;
    }

    protected void afterOpen() throws Exception {}
    protected BaseHandler getHandler(){
        return new BaseHandler();
    }

    protected abstract StreamProperty getProperty();
}
