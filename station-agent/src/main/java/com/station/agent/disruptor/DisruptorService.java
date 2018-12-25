package com.station.agent.disruptor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ThreadFactory;

public class DisruptorService {
    private static final Disruptor<DataEvent> disruptor;
    private static final RingBuffer<DataEvent> buffer;
    private static final ThreadFactory factory;
    static {
        factory = new ThreadFactoryBuilder().setNameFormat("DataEvent---%d").build();
        final int buffSize = 8 * 1024;
        disruptor = new Disruptor<>(new DataEventFactory(), buffSize, factory,
                ProducerType.MULTI, new BlockingWaitStrategy());
        buffer = disruptor.getRingBuffer();
        EventHandler<DataEvent> eventHandler = new DataEventHandler();
        disruptor.handleEventsWith(eventHandler);
        disruptor.start();
    }

    public static void publishEvent(String topic, byte[] bytes) {
        long sequence = buffer.next();
        try {
            DataEvent event = buffer.get(sequence);
            event.setTopic(topic);
            event.setBytes(bytes);
        } finally {
            buffer.publish(sequence);
        }

    }
}
