package com.station.agent.stream.base;

import com.station.agent.stream.DataStreamCreator;
import com.station.agent.stream.propertys.StreamProperty;
import com.station.common.domain.Station;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

import javax.annotation.PostConstruct;

public abstract class AbstractClientDataStreamCreator implements DataStreamCreator {
    private static final NioEventLoopGroup worker = new NioEventLoopGroup();
    private static final Bootstrap bootstrap = new Bootstrap();
    private static final int SO_TIMEOUT = 6000;
    private static final int CONNECT_TIMEOUT = 2000;

    static {
        bootstrap.group(worker);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.RCVBUF_ALLOCATOR, new DefaultMaxBytesRecvByteBufAllocator())
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new IdleStateHandler(SO_TIMEOUT, SO_TIMEOUT, SO_TIMEOUT))
                                .addLast(new ByteArrayDecoder())
                                .addLast(new StringEncoder());
                    }
                });
    }

    protected Channel connect(String ip, Integer port) throws InterruptedException {
        ChannelFuture future = bootstrap.connect(ip, port);
        future.awaitUninterruptibly(CONNECT_TIMEOUT);
        if (!future.isSuccess()){
            throw new InterruptedException("connect time out");
        }else {
            return future.channel();
        }
    }
}
