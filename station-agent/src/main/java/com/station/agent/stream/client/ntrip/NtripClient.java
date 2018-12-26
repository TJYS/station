package com.station.agent.stream.client.ntrip;

import com.station.agent.stream.base.BaseClient;
import com.station.agent.stream.base.BaseHandler;
import com.station.agent.stream.propertys.NtripStreamProperty;
import com.station.agent.stream.propertys.StreamProperty;
import io.netty.channel.Channel;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class NtripClient extends BaseClient {

    private NtripStreamProperty property;

    public NtripClient(Channel channel) {
        this.channel = channel;
    }

    public void setProperty(StreamProperty property) {
        this.property = (NtripStreamProperty) property;
    }

    @Override
    public void open() throws Exception {
        super.open();
        byte[] tembts = (property.getUser() + ":" + property.getPwd()).getBytes("US-ASCII");
        String encodedUserpassword = new Base64().encodeToString(tembts);
        String greet = String.format("GET /%s HTTP/1.1 \r\n" +
                "User-Agent: NTRIP CHC/1.0.0 \r\n" +
                "Accept: */* \r\n" +
                "Connection: Keep-Alive \r\n" +
                "Authorization: Basic %s \r\n", property.getSource(), encodedUserpassword);
        channel.writeAndFlush(greet);
    }

    @Override
    protected StreamProperty getProperty() {
        return property;
    }
}
