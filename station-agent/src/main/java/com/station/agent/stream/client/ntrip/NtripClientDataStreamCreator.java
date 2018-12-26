package com.station.agent.stream.client.ntrip;

import com.station.agent.stream.base.AbstractClientDataStreamCreator;
import com.station.agent.stream.DataStream;
import com.station.agent.stream.base.BaseClient;
import com.station.agent.stream.client.tcp.TcpClient;
import com.station.agent.stream.propertys.NtripStreamProperty;
import com.station.agent.stream.propertys.StreamProperty;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

@Component("NtripClientDataStreamCreator")
public class NtripClientDataStreamCreator extends AbstractClientDataStreamCreator {
    @Override
    public DataStream create(StreamProperty property) throws InterruptedException {
        Channel channel = connect(property.getIp(), property.getPort());
        NtripClient client = new NtripClient(channel);
        client.setProperty(property);
        return client;
    }
}
