package com.station.agent.stream.core;

public interface DataStream {
    void open() throws Exception;

    void close();
}
