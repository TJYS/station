package com.station.agent.stream.propertys;

import lombok.Data;

@Data
public class NtripStreamProperty extends StreamProperty {
    private String user;
    private String pwd;
    private String source;
}
