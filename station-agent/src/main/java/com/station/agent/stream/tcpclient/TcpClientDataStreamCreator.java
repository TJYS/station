package com.station.agent.stream.tcpclient;

import com.station.agent.stream.AbstractClientDataStreamCreator;
import com.station.agent.stream.DataStream;
import com.station.agent.stream.propertys.StreamProperty;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

@Component("TcpClientDataStreamCreator")
public class TcpClientDataStreamCreator extends AbstractClientDataStreamCreator {
    @Override
    public DataStream create(StreamProperty property) throws InterruptedException {
        Channel channel = connect(property.getIp(), property.getPort());
        TcpClient client = new TcpClient(channel);
        client.setProperty(property);
        return client;
    }
}
