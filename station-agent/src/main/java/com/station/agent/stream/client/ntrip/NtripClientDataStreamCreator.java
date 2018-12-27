package com.station.agent.stream.client.ntrip;

import com.station.agent.station.Receiver;
import com.station.agent.stream.core.DataStream;
import com.station.agent.stream.core.tools.AbstractClientDataStreamCreator;
import com.station.common.domain.Station;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

@Component("NtripClientDataStreamCreator")
public class NtripClientDataStreamCreator extends AbstractClientDataStreamCreator {
    @Override
    public DataStream create(Receiver receiver) throws InterruptedException {
        NtripStreamProperty property = generate(receiver.getProperty());
        Channel channel = connect(property.getIp(), property.getPort());
        NtripClient client = new NtripClient(channel);
        client.setProperty(property);
        return client;
    }

    private NtripStreamProperty generate(Station station){
        NtripStreamProperty property = new NtripStreamProperty();
        property.setOwner(station.getName());
        property.setIp(station.getIp());
        property.setPort(station.getPort());
        property.setUser(station.getNtripUser());
        property.setPwd(station.getNtripPwd());
        property.setSource(station.getNtripSource());
        return property;
    }
}
