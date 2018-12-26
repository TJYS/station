package com.station.agent.stream;

public interface DataStream {
    void open() throws Exception;

    void close();
}
