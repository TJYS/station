package com.station.agent.stream.core;

import com.station.agent.station.Receiver;

public interface DataStreamCreator{
    /**
     * 根据Station生成数据流
     *
     * @param receiver 测站
     * @return 网络数据流
     */
   DataStream create(Receiver receiver) throws InterruptedException;
}
