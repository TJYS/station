package com.station.agent.stream;

import com.station.agent.stream.enums.NetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DataStreamCreatorHolder {
    @Autowired
    private Map<String, DataStreamCreator> dataStreamCreators;

    /**
     * 根据网络类型查找数据流生成器
     *
     * @param type
     * @return
     */
    public DataStreamCreator findDataStreamCreator(NetType type) {
        return findDataStreamCreator(type.toString());
    }

    public DataStreamCreator findDataStreamCreator(String type) {
        String name = type + DataStreamCreator.class.getSimpleName();
        DataStreamCreator creator = dataStreamCreators.get(name);
        if (creator == null) {
            throw new RuntimeException("不支持的数据流类型");
        }
        return creator;
    }
}
