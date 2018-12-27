package com.station.agent.stream.client.tcp;

import com.station.agent.station.Receiver;
import com.station.agent.stream.core.StreamProperty;
import com.station.agent.stream.core.tools.AbstractClientDataStreamCreator;
import com.station.agent.stream.core.DataStream;
import com.station.common.domain.Station;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

@Component("TcpClientDataStreamCreator")
public class TcpClientDataStreamCreator extends AbstractClientDataStreamCreator {
    @Override
    public DataStream create(Receiver receiver) throws InterruptedException {
        StreamProperty property = generate(receiver.getProperty());
        Channel channel = connect(property.getIp(), property.getPort());
        TcpClient client = new TcpClient(channel);
        client.setProperty(property);
        return client;
    }


    private StreamProperty generate(Station station){
        StreamProperty property = new StreamProperty();
        property.setOwner(station.getName());
        property.setIp(station.getIp());
        property.setPort(station.getPort());
        return property;
    }
}
