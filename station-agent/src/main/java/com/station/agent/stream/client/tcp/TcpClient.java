package com.station.agent.stream.client.tcp;

import com.station.agent.stream.core.StreamProperty;
import com.station.agent.stream.core.tools.BaseClient;
import io.netty.channel.Channel;

public class TcpClient extends BaseClient {
    private StreamProperty property;

    public TcpClient(Channel channel) {
        this.channel = channel;
    }

    public void setProperty(StreamProperty property) {
        this.property = property;
    }

    @Override
    protected StreamProperty getProperty() {
        return property;
    }
}
