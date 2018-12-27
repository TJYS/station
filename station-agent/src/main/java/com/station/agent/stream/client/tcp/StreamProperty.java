package com.station.agent.stream.client.tcp;

import lombok.Data;

@Data
public class StreamProperty {
    private String owner;
    private String ip;
    private Integer port;
}
