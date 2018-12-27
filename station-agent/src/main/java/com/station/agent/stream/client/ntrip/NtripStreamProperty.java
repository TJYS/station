package com.station.agent.stream.client.ntrip;

import com.station.agent.stream.core.StreamProperty;
import lombok.Data;

@Data
public class NtripStreamProperty extends StreamProperty {
    private String user;
    private String pwd;
    private String source;
}
