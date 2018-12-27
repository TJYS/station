package com.station.agent.stream.client.ntrip;

import com.station.agent.stream.client.tcp.StreamProperty;
import lombok.Data;

@Data
public class NtripStreamProperty extends StreamProperty {
    private String user;
    private String pwd;
    private String source;
}
