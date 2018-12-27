package com.station.agent.stream.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NetType {
    TcpClient(0, "TcpClient"),
    TcpServer(1, "TcpServer"),
    NtripClient(2, "NtripClient"),
    NtripServer(3, "NtripServer"),
    ;
    private Integer value;
    private String name;

    public static NetType findByValue(Integer value) {
        for (NetType type : NetType.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        return null;
    }
}
