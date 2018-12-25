package com.station.agent.stream;

import com.station.agent.stream.propertys.StreamProperty;

public interface DataStreamCreator<T extends StreamProperty> {
    /**
     * 根据Station生成数据流
     *
     * @param property 测站结构
     * @return 网络数据流
     */
    DataStream create(T property) throws InterruptedException;
}
